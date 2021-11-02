CREATE TABLE
	VEICULO(
		idVeiculo INT PRIMARY KEY AUTO_INCREMENT, 
		nome VARCHAR(30), 
		marca VARCHAR(30), 
		modelo VARCHAR(30), 
		data_fabric DATETIME, 
		cons_med_cidade DOUBLE, 
		cons_med_rodov DOUBLE
	);
	
INSERT INTO 
	VEICULO(
		NOME, MARCA, MODELO, DATA_FABRIC, CONS_MED_CIDADE, CONS_MED_RODOV
	) 
VALUES 
	('Nome X', 'Hyundai', 'I30', '2021-11-02', 10, 12);