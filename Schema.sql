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