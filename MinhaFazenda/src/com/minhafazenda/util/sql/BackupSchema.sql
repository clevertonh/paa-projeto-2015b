-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.5.41-0ubuntu0.14.04.1 - (Ubuntu)
-- OS do Servidor:               debian-linux-gnu
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para fazenda
CREATE DATABASE IF NOT EXISTS `fazenda` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fazenda`;


-- Copiando estrutura para tabela fazenda.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `raca_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `grau_sangue_id` int(11) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `numero_botton` int(11) DEFAULT NULL,
  `tipo_registro` int(11) DEFAULT NULL,
  `id_pai` int(11) DEFAULT NULL,
  `id_mae` int(11) DEFAULT NULL,
  `propriedade_rural_id` int(11) NOT NULL,
  `id_usuario_alterou` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_animal_raca1_idx` (`raca_id`),
  KEY `fk_animal_categoria1_idx` (`categoria_id`),
  KEY `fk_animal_grau_sangue1_idx` (`grau_sangue_id`),
  KEY `fk_animal_animal1_idx` (`id_pai`),
  KEY `fk_animal_animal2_idx` (`id_mae`),
  KEY `fk_animal_propriedade_rural1_idx` (`propriedade_rural_id`),
  CONSTRAINT `fk_animal_animal1` FOREIGN KEY (`id_pai`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_animal2` FOREIGN KEY (`id_mae`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_grau_sangue1` FOREIGN KEY (`grau_sangue_id`) REFERENCES `grau_sangue` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_propriedade_rural1` FOREIGN KEY (`propriedade_rural_id`) REFERENCES `propriedade_rural` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_raca1` FOREIGN KEY (`raca_id`) REFERENCES `raca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.cidade
CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `estado_id` int(11) NOT NULL,
  `id_usuario_alterou` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cidade_estado1_idx` (`estado_id`),
  CONSTRAINT `fk_cidade_estado1` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` char(2) DEFAULT NULL,
  `pais_id` int(11) NOT NULL,
  `id_usuario_alterou` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_estado_pais1_idx` (`pais_id`),
  CONSTRAINT `fk_estado_pais1` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.fotos
CREATE TABLE IF NOT EXISTS `fotos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `nome_arquivo` varchar(100) NOT NULL,
  `animal_id` int(11) NOT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fotos_animal1_idx` (`animal_id`),
  CONSTRAINT `fk_fotos_animal1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.grau_sangue
CREATE TABLE IF NOT EXISTS `grau_sangue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.mf_auditoria
CREATE TABLE IF NOT EXISTS `mf_auditoria` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) DEFAULT NULL,
  `tabela` varchar(255) DEFAULT NULL,
  `chave_primaria_1` varchar(255) DEFAULT NULL,
  `chave_primaria_2` varchar(255) DEFAULT NULL,
  `acao` varchar(6) DEFAULT NULL COMMENT 'Values: insert|update|delete',
  `data_hora` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `pk_index` (`tabela`,`chave_primaria_1`,`chave_primaria_2`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.mf_auditoria_configuracao
CREATE TABLE IF NOT EXISTS `mf_auditoria_configuracao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tabela` varchar(255) DEFAULT '0',
  `trigger_delete` varchar(255) DEFAULT '0',
  `trigger_insert` varchar(255) DEFAULT '0',
  `trigger_update` varchar(255) DEFAULT '0',
  `view_auditoria` varchar(255) DEFAULT '0',
  `view_auditoria_item` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para procedure fazenda.mf_auditoria_gerar_script
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `mf_auditoria_gerar_script`(IN nome_banco VARCHAR(255), IN nome_tabela VARCHAR(255), OUT errors LONGTEXT)
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


	SET errors := erro_ocorrido;
	

END//
DELIMITER ;


-- Copiando estrutura para tabela fazenda.mf_auditoria_item
CREATE TABLE IF NOT EXISTS `mf_auditoria_item` (
  `id_auditoria_item` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_auditoria` bigint(20) unsigned NOT NULL,
  `campo` varchar(255) NOT NULL,
  `valor_antigo` longtext,
  `valor_novo` longtext,
  PRIMARY KEY (`id_auditoria_item`),
  KEY `zaudit_meta_index` (`id_auditoria`,`campo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para procedure fazenda.mf_auditoria_remover
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `mf_auditoria_remover`(IN nome_banco VARCHAR(255), IN nome_tabela VARCHAR(255))
main_block: BEGIN

	SELECT CONCAT(	'DELETE FROM mf_auditoria_configuracao WHERE tabela = \'', nome_tabela, '\'')
	UNION 
	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_INSERT')
	UNION 
	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_UPDATE')
	UNION 
	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_DELETE')
	UNION 
	SELECT CONCAT(	'DROP VIEW IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW_item')
	UNION 
	SELECT CONCAT(	'DROP VIEW IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW');	
END//
DELIMITER ;


-- Copiando estrutura para tabela fazenda.pais
CREATE TABLE IF NOT EXISTS `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.producao_leite
CREATE TABLE IF NOT EXISTS `producao_leite` (
  `id` int(11) NOT NULL,
  `data_hora` datetime DEFAULT NULL,
  `id_animal` int(11) NOT NULL,
  `quantidade_ml` int(11) DEFAULT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_producao_leite_animal1_idx` (`id_animal`),
  CONSTRAINT `fk_producao_leite_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.propriedade_rural
CREATE TABLE IF NOT EXISTS `propriedade_rural` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `tamanho` int(11) DEFAULT NULL,
  `cep` char(9) DEFAULT NULL,
  `cidades_id` int(11) NOT NULL,
  `id_usuario_alterou` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_propriedade_rural_cidades_idx` (`cidades_id`),
  CONSTRAINT `fk_propriedade_rural_cidades` FOREIGN KEY (`cidades_id`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.raca
CREATE TABLE IF NOT EXISTS `raca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `nome_arquivo` varchar(45) DEFAULT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `id_usuario_tipo` int(11) NOT NULL,
  `id_usuario_alterou` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_usuario_tipo1_idx` (`id_usuario_tipo`),
  CONSTRAINT `fk_usuario_usuario_tipo1` FOREIGN KEY (`id_usuario_tipo`) REFERENCES `usuario_tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.usuario_propriedade_rural
CREATE TABLE IF NOT EXISTS `usuario_propriedade_rural` (
  `id_usuario` int(11) NOT NULL,
  `id_propriedade_rural` int(11) NOT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`,`id_propriedade_rural`),
  KEY `fk_usuario_has_propriedade_rural_propriedade_rural1_idx` (`id_propriedade_rural`),
  KEY `fk_usuario_has_propriedade_rural_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_usuario_has_propriedade_rural_propriedade_rural1` FOREIGN KEY (`id_propriedade_rural`) REFERENCES `propriedade_rural` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_propriedade_rural_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.usuario_tipo
CREATE TABLE IF NOT EXISTS `usuario_tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.vacina
CREATE TABLE IF NOT EXISTS `vacina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `modo_uso` text,
  `indicacoes` text,
  `vacinacol` varchar(45) DEFAULT NULL,
  `dias_validade` int(11) DEFAULT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela fazenda.vacina_animal
CREATE TABLE IF NOT EXISTS `vacina_animal` (
  `id_vacina` int(11) NOT NULL,
  `id_animal` int(11) NOT NULL,
  `sequencia` int(11) NOT NULL,
  `data_aplicacao` date DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `dose` int(11) DEFAULT NULL,
  `id_usuario_alterou` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_vacina`,`id_animal`,`sequencia`),
  KEY `fk_vacina_has_animal_animal1_idx` (`id_animal`),
  KEY `fk_vacina_has_animal_vacina1_idx` (`id_vacina`),
  KEY `fk_vacina_animal_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_vacina_animal_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacina_has_animal_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacina_has_animal_vacina1` FOREIGN KEY (`id_vacina`) REFERENCES `vacina` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
