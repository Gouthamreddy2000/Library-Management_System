CREATE DATABASE library_db;

USE `library_db`;

CREATE TABLE `users` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('goutham','{noop}test123',1),
('dileep','{noop}test123',1),
('rohith','{noop}test123',1);


CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
('john','ROLE_STUDENT'),
('mary','ROLE_STUDENT'),
('goutham','ROLE_STUDENT'),
('dileep','ROLE_STUDENT'),
('rohith','ROLE_STUDENT'),
('susan','ROLE_STUDENT');




drop table `registrations`
USE `library_db`;

DROP TABLE IF EXISTS registrations;

CREATE TABLE registrations (
  id INT NOT NULL AUTO_INCREMENT,
  first_name CHAR(68) NOT NULL,
  last_name CHAR(68) NOT NULL,
  password VARCHAR(68) NOT NULL,
  confirm_password VARCHAR(68) NOT NULL,
  email VARCHAR(68) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  active TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  UNIQUE KEY uk_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE registrations
MODIFY active TINYINT(1) NOT NULL DEFAULT 1;

ALTER TABLE registrations DROP PRIMARY KEY;



ALTER TABLE registrations
ADD COLUMN role VARCHAR(50) DEFAULT 'ROLE_USER';

UPDATE registrations
SET password = CONCAT('{noop}', password)
WHERE id > 0
AND password NOT LIKE '{noop}%';



