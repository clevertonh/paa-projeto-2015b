DELIMITER $$

DROP PROCEDURE IF EXISTS mf_auditoria_gerar_script;
$$

CREATE PROCEDURE mf_auditoria_gerar_script(IN nome_banco VARCHAR(255), IN nome_tabela VARCHAR(255), OUT script LONGTEXT, OUT errors LONGTEXT)
main_block: BEGIN

	DECLARE TRIGGER_INSERT LONGTEXT;
	DECLARE TRIGGER_UPDATE LONGTEXT;
	DECLARE TRIGGER_DELETE LONGTEXT;
	DECLARE VIEW_AUDITORIA LONGTEXT;
	DECLARE VIEW_AUDITORIA_item LONGTEXT;
	DECLARE erro_ocorrido LONGTEXT;
	
	DECLARE stmt LONGTEXT;
		DECLARE stmt_ LONGTEXT;
	DECLARE at_id1, at_id2 LONGTEXT;
	DECLARE c INTEGER;

	-- Default max length of GROUP_CONCAT IS 1024
	SET SESSION group_concat_max_len = 100000;

	SET erro_ocorrido := '';

	-- ----------------------------------------------------------
	-- Verifica se a tabela especificada existe
	-- ----------------------------------------------------------	
	SET c := (	SELECT 
						COUNT(*) 
					FROM 
						information_schema.tables 
					WHERE 
						BINARY TABLE_SCHEMA = BINARY nome_banco 
						AND BINARY table_name = BINARY nome_tabela );
						
	IF c <> 1 THEN
		SET erro_ocorrido := CONCAT(erro_ocorrido, '\n', 'A tabela que você especificou `', nome_banco, '`.`', nome_tabela, '` não existe.' );
		LEAVE main_block;
	END IF;

	-- ----------------------------------------------------------
	-- Verifica se existe as tabelas da AUDITORIA
	-- ----------------------------------------------------------	
	SET c := (	SELECT 
						COUNT(*) 
					FROM 
						information_schema.tables 
					WHERE 
						BINARY TABLE_SCHEMA = BINARY nome_banco 
						AND (BINARY table_name = BINARY 'mf_auditoria' OR BINARY table_name = BINARY 'mf_auditoria_item')	);
						
	IF c <> 2 THEN
		SET erro_ocorrido := CONCAT(erro_ocorrido, '\n', 'Estrutura de tabelas para auditoria não existe.' );
	END IF;

	-- ----------------------------------------------------------
	-- Verifica se existe as triggers
	-- ----------------------------------------------------------
/*
	SET c := (	SELECT 
						GROUP_CONCAT(TRIGGER_NAME, ', ') 
					FROM 
						information_schema.triggers
					WHERE 
						BINARY EVENT_OBJECT_SCHEMA = BINARY nome_banco 
						AND BINARY EVENT_OBJECT_TABLE = BINARY nome_tabela 
						AND BINARY ACTION_TIMING = BINARY 'AFTER' 
						AND BINARY TRIGGER_NAME NOT LIKE BINARY CONCAT('z', nome_tabela, '_%') 
					GROUP BY 
						EVENT_OBJECT_TABLE	);
			
	IF c IS NOT NULL AND LENGTH(c) > 0 THEN
		SET erro_ocorrido := CONCAT(erro_ocorrido, '\n', 'MySQL 5 suporta apenas um gatilho por insert/update/delete. Atualmente, existem as seguintes triggers (', c, ') já atribuído a `', nome_banco, '`.`', nome_tabela, '`. Você deve removê-las antes de a triggers de auditoria pode ser criada');
	END IF;
*/
	
	-- ----------------------------------------------------------
	-- Obter a primeira chave primária
	-- ----------------------------------------------------------
	SET at_id1 := (SELECT 
							COLUMN_NAME 
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco 
							AND BINARY table_name = BINARY nome_tabela
							AND column_key = 'PRI' LIMIT 1	);

	-- ----------------------------------------------------------
	-- Obter a segunda chave primária
	-- ----------------------------------------------------------
	SET at_id2 := (SELECT 
							COLUMN_NAME 
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco 
							AND BINARY table_name = BINARY nome_tabela
							AND column_key = 'PRI' LIMIT 1,1	);

	-- ----------------------------------------------------------
	-- Verifica se existe pelo menos uma CHAVE PRIMARIA
	-- ----------------------------------------------------------
	IF at_id1 IS NULL AND at_id2 IS NULL THEN 
		SET erro_ocorrido := CONCAT(erro_ocorrido, '\n', 'A tabela que você especificou `', nome_banco, '`.`', nome_tabela, '` não tem nanhuma chave primária.');
	END IF;
	
	SET TRIGGER_INSERT := CONCAT(	'CREATE TRIGGER ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_INSERT AFTER INSERT ON ', nome_banco, '.', nome_tabela, ' FOR EACH ROW \nBEGIN\n');											
											
	SET TRIGGER_UPDATE := CONCAT( 'CREATE TRIGGER ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_UPDATE AFTER UPDATE ON ', nome_banco, '.', nome_tabela, ' FOR EACH ROW \nBEGIN\n');											
											
	SET TRIGGER_DELETE := CONCAT( 'CREATE TRIGGER ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_DELETE AFTER DELETE ON ', nome_banco, '.', nome_tabela, ' FOR EACH ROW \nBEGIN\n');

	SET stmt := 'DECLARE mf_auditoria_last_inserted_id BIGINT(20);\n\n';
	
	SET TRIGGER_INSERT := CONCAT( TRIGGER_INSERT, stmt );
	SET TRIGGER_UPDATE := CONCAT( TRIGGER_UPDATE, stmt );
	SET TRIGGER_DELETE := CONCAT( TRIGGER_DELETE, stmt );



	SET stmt := CONCAT(	'INSERT IGNORE INTO '
								,nome_banco
								,'.mf_auditoria (usuario, tabela, chave_primaria_1, '
								,CASE WHEN at_id2 IS NULL THEN '' ELSE 'chave_primaria_2, ' END 
								,'acao) VALUES (IFNULL(@mf_auditoria_usuario, USER()), '
								,''''
								,nome_tabela
								,''', '
								,'NEW.'
								,at_id1
								,', '
								,IFNULL(CONCAT('NEW.', at_id2, ', ') , ''));
							
	SET TRIGGER_INSERT := CONCAT(TRIGGER_INSERT, stmt, '''INSERT''); \n\n');
											
	SET stmt := CONCAT(	'INSERT IGNORE INTO '
								,nome_banco
								,'.mf_auditoria (usuario, tabela, chave_primaria_1, '
								,CASE WHEN at_id2 IS NULL THEN '' ELSE 'chave_primaria_2, ' END 
								,'acao) VALUES (IFNULL(@mf_auditoria_usuario, USER()), '
								,''''
								,nome_tabela
								,''', '
								,'OLD.'
								,at_id1
								,', '
								,IFNULL(CONCAT('OLD.', at_id2, ', ') , ''));

	SET TRIGGER_UPDATE := CONCAT(TRIGGER_UPDATE, stmt, '''UPDATE''); \n\n' );
	SET TRIGGER_DELETE := CONCAT(TRIGGER_DELETE, stmt, '''DELETE''); \n\n' );

	SET stmt := 'SET mf_auditoria_last_inserted_id = LAST_INSERT_ID();\n';
	
	SET TRIGGER_INSERT := CONCAT(TRIGGER_INSERT, stmt );
	SET TRIGGER_UPDATE := CONCAT(TRIGGER_UPDATE, stmt );
	SET TRIGGER_DELETE := CONCAT(TRIGGER_DELETE, stmt );
	
	SET stmt := CONCAT(	'INSERT IGNORE INTO '
								,nome_banco
								,'.mf_auditoria_item (id_auditoria, campo, valor_antigo, valor_novo) VALUES \n' );

	SET TRIGGER_INSERT := CONCAT(TRIGGER_INSERT, '\n', stmt );
	SET TRIGGER_UPDATE := CONCAT(TRIGGER_UPDATE, '\n', stmt );
	SET TRIGGER_DELETE := CONCAT(TRIGGER_DELETE, '\n', stmt );

	SET stmt := (	SELECT 
							GROUP_CONCAT(' (mf_auditoria_last_inserted_id, ''', COLUMN_NAME, ''', NULL, ',	
								CASE WHEN INSTR( '|binary|varbinary|tinyblob|blob|mediumblob|longblob|', LOWER(DATA_TYPE) ) <> 0 THEN 
									'''[SEM SUPORTE A TIPOS DE DADOS BINARIOS]''' 
								ELSE 						
									CONCAT('NEW.', COLUMN_NAME, '')
								END,
							'),'
							SEPARATOR '\n')
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco
							AND BINARY TABLE_NAME = BINARY nome_tabela );
							
							

-- SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n$$' );
	SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n' );
	SET TRIGGER_INSERT := CONCAT( TRIGGER_INSERT, stmt );

	SET stmt := (	SELECT 
							GROUP_CONCAT('   (mf_auditoria_last_inserted_id, ''', COLUMN_NAME, ''', ', 
								CASE WHEN INSTR( '|binary|varbinary|tinyblob|blob|mediumblob|longblob|', LOWER(DATA_TYPE) ) <> 0 THEN
									'''[MESMO]'''
								ELSE
									CONCAT('OLD.', COLUMN_NAME, '')
								END,	
							', ',
								CASE WHEN INSTR( '|binary|varbinary|tinyblob|blob|mediumblob|longblob|', LOWER(DATA_TYPE) ) <> 0 THEN
									CONCAT('CASE WHEN BINARY OLD.', COLUMN_NAME, ' <=> BINARY NEW.', COLUMN_NAME, ' THEN ''[SAME]'' ELSE ''[CHANGED]'' END')
								ELSE
									CONCAT('NEW.', COLUMN_NAME, '')
								END,
							'),'
							SEPARATOR '\n') 
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco 
							AND BINARY TABLE_NAME = BINARY nome_tabela );

-- SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n$$' );
	SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n' );	
	SET TRIGGER_UPDATE := CONCAT( TRIGGER_UPDATE, stmt );


	SET stmt := (	SELECT 
							GROUP_CONCAT('   (mf_auditoria_last_inserted_id, ''', COLUMN_NAME, ''', ', 
								CASE WHEN INSTR( '|binary|varbinary|tinyblob|blob|mediumblob|longblob|', LOWER(DATA_TYPE) ) <> 0 THEN 
									'''[SEM SUPORTE A TIPOS DE DADOS BINARIOS]''' 
								ELSE 						
									CONCAT('OLD.', COLUMN_NAME, '')
								END,
								', NULL ),'
							SEPARATOR '\n') 
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco 
							AND BINARY TABLE_NAME = BINARY nome_tabela );


-- SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n$$' );
	SET stmt := CONCAT( TRIM( TRAILING ',' FROM stmt ), ';\n\nEND\n' );	
	SET TRIGGER_DELETE := CONCAT( TRIGGER_DELETE, stmt );

								
	SET stmt := CONCAT(	'CREATE VIEW ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW_item AS \n',
								'SELECT za.id, zm.id_auditoria_item, za.usuario, \n',
								'	za.chave_primaria_1, za.chave_primaria_2,\n',
								'	za.acao, zm.campo, zm.valor_antigo, zm.valor_novo, za.data_hora\n',
								'FROM ', nome_banco, '.mf_auditoria za \n', 
								'INNER JOIN ', nome_banco, '.mf_auditoria_item zm ON za.id = zm.id_auditoria \n',
								'WHERE za.tabela = ''', nome_tabela, '''');								

-- SET VIEW_AUDITORIA_item := CONCAT(stmt, '$$');
	SET VIEW_AUDITORIA_item := CONCAT(stmt, '');	


	SET stmt := (	SELECT
							GROUP_CONCAT('	MAX((CASE WHEN zm.campo = ''', COLUMN_NAME, ''' THEN zm.valor_antigo ELSE NULL END)) AS ', COLUMN_NAME, '_old, \n',
										'		MAX((CASE WHEN zm.campo = ''', COLUMN_NAME, ''' THEN zm.valor_novo ELSE NULL END)) AS ', COLUMN_NAME, '_new, \n' 
							SEPARATOR '\n') 
						FROM 
							information_schema.columns
						WHERE 
							BINARY TABLE_SCHEMA = BINARY nome_banco 
							AND BINARY TABLE_NAME = BINARY nome_tabela	);
							
	SET stmt := TRIM( TRAILING ', \n' FROM stmt );		
	SET stmt := ( SELECT
						CONCAT( 	'CREATE VIEW ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW AS \n', 
									'SELECT za.id, za.usuario, za.chave_primaria_1, za.chave_primaria_2,\n', 
									'za.acao, za.data_hora, \n', 
									stmt , '\n',
									'	FROM ', nome_banco, '.mf_auditoria za \n', 
									'	INNER JOIN ', nome_banco, '.mf_auditoria_item zm ON za.id = zm.id_auditoria \n'
									'WHERE za.tabela = ''', nome_tabela, '''\n',
									'GROUP BY zm.id_auditoria') );

-- 	SET VIEW_AUDITORIA := CONCAT( stmt, '\n$$' );
		SET VIEW_AUDITORIA := stmt;



-- SET @cv := CONCAT('DELIMITER $$','\n\n',TRIGGER_INSERT,';');
-- PREPARE cstmt FROM @cv;
-- EXECUTE cstmt;
-- DEALLOCATE PREPARE cstmt;
-- 

-- SELECT CONCAT('DELIMITER $$','\n\n',TRIGGER_INSERT,';')
	SELECT TRIGGER_INSERT	
	UNION
	SELECT TRIGGER_UPDATE
	UNION
	SELECT TRIGGER_DELETE
	UNION
	SELECT VIEW_AUDITORIA_item
	UNION
	SELECT VIEW_AUDITORIA;					

/*
	SET stmt = CONCAT('DELIMITER $$'
							,'\n\n'
							,TRIGGER_INSERT
							,'\n\n'
							,TRIGGER_UPDATE
							,'\n\n'
							,TRIGGER_DELETE
							,'\n\n'
							,VIEW_AUDITORIA_item
							,'\n\n'
							,VIEW_AUDITORIA);
*/
/*
SET @cv := VIEW_AUDITORIA;
PREPARE cstmt FROM @cv;
EXECUTE cstmt;
DEALLOCATE PREPARE cstmt;
*/
-- 
-- SET @cv := stmt;
-- PREPARE cstmt FROM @cv;
-- EXECUTE cstmt;
--    DEALLOCATE PREPARE cstmt;

	SET script := stmt;
	SET errors := erro_ocorrido;
	

END
$$