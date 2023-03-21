DROP DATABASE IF EXISTS `wisdombase`;
CREATE DATABASE IF NOT EXISTS `wisdombase`;
CREATE USER 'root'@'%' IDENTIFIED BY 'secret'; 
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
CREATE USER 'scrappy'@'%' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON `wisdombase`.* TO 'scrappy'@'%' WITH GRANT OPTION;
GRANT USAGE ON *.* TO 'root'@'%';
GRANT USAGE ON *.* TO 'scrappy'@'%';
FLUSH PRIVILEGES;
CREATE TABLE IF NOT EXISTS `wisdombase`.`posts` (
	  `id` int unsigned NOT NULL AUTO_INCREMENT,
	  `post_content` varchar(225) DEFAULT NULL,
	  PRIMARY KEY (`id`)
	);
