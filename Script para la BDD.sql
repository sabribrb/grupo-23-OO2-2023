-- MYSQL WORKBENCH
-- Para comenzar a usar el sistema, debemos primero correr la siguiente sentencia SQL 
-- Aunque Spring JPA nos creará la base de datos, debe captarla ya creada manualmente.
-- Para eso ejecutar la sifuiente linea:
CREATE DATABASE IF NOT EXISTS `bd-grupo23-oo2`;

-- Luego debemos cargar en el archivo de configuracion application.yml los datos correctos (URL de la BD, usuario y password)
-- Despues de haber levantado exitosamente la aplicacion de Spring con el IDE por primera vez,
-- debemos terminar la instancia, entrar en MySql Workbench y correr el siguiente bloque:
USE `bd-grupo23-oo2`;
INSERT INTO `bd-grupo23-oo2`.edificio (nombre) VALUES
	('Scalabrini Ortiz'),
	('Arturo Jauretche'),
	('Leopoldo Marechal'),
	('Manuel Ugarte'),
	('Juana Manso'),
	('José Hernández'),
	('Homero Manzi'),
	('Tita Merello'),
	('Macedonio Fernández');
    
-- Listo! Ya podes probar las funcionalidades de nuestro sistema