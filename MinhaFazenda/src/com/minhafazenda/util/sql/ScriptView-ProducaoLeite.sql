CREATE VIEW view_producao_leite AS
SELECT 
	pl.id
	,pl.data_hora
	,ani.nome AS animal_nome
	,ra.descricao AS animal_raca
	,ca.descricao AS animal_categoria
	,gs.descricao AS animal_grau_sangue
	,pl.quantidade_ml
FROM
	producao_leite AS pl
		LEFT JOIN animal AS ani ON
			pl.id_animal = ani.id
				LEFT JOIN raca AS ra ON
					ani.raca_id = ra.id
				LEFT JOIN categoria AS ca ON
					ani.categoria_id = ca.id
				LEFT JOIN grau_sangue AS gs ON
					ani.grau_sangue_id = gs.id