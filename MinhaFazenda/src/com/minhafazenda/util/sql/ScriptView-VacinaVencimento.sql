CREATE VIEW view_vacina_vencimento AS
SELECT
	v.descricao AS vacina_descricao
	,v.modo_uso AS vacina_modo_usaro
	,va.data_vencimento AS vacina_data_vencimento
	,va.dose AS vacina_dose
	,ani.nome AS animal_nome
	,ra.descricao AS animal_raca
FROM
	vacina_animal AS va
		LEFT JOIN vacina AS v ON
			va.id_vacina = v.id
		LEFT JOIN animal AS ani ON
			va.id_animal = ani.id
				LEFT JOIN raca AS ra ON
					ani.raca_id = ra.id
WHERE
	va.data_vencimento >= CURDATE()
	AND va.data_vencimento <= DATE_ADD(CURDATE(),INTERVAL 1 MONTH)
	