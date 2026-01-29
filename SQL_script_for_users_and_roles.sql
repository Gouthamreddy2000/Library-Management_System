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