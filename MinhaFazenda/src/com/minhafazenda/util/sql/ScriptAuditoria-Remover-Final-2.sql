DELIMITER $$

DROP PROCEDURE IF EXISTS mf_auditoria_remover;
$$

CREATE PROCEDURE mf_auditoria_remover(IN nome_banco VARCHAR(255), IN nome_tabela VARCHAR(255))
main_block: BEGIN

	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_INSERT')
	UNION 
	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_UPDATE')
	UNION 
	SELECT CONCAT(	'DROP TRIGGER IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_TRIGGER_DELETE')
	UNION 
	SELECT CONCAT(	'DROP VIEW IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW_item')
	UNION 
	SELECT CONCAT(	'DROP VIEW IF EXISTS ', nome_banco, '.', nome_tabela, '_AUDITORIA_VIEW');	
END
$$