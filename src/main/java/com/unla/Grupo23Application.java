package com.unla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.unla")
public class Grupo23Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo23Application.class, args);
	}

	/*-----------Script que genera los edificios en la bd--------------/
	 
	INSERT INTO `bd-grupo23-oo2`.edificio (nombre) VALUES
	('Scalabrini Ortiz'),
	('Arturo Jauretche'),
	('Leopoldo Marechal'),
	('Manuel Ugarte'),
	('Juana Manso'),
	('José Hernández'),
	('Homero Manzi'),
	('Tita Merello'),
	('Macedonio Fernández');*/

}
