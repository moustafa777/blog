INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`, `user_name`) VALUES 
	('1', 'ryan@mum.edu', 'Ryan', 'Moussa', '123', 'ryan'),
 	('2', 'yahia@mum.edu', 'Yahia', 'Elakeed', '123', 'yahia'),
	('3', 'mous@mum.edu', 'Moustafa', 'Sayed', '123', 'moustafa');
INSERT INTO `role` (`id`, `role_name`) VALUES
	(1, 'APP_ADMIN'),
	(2, 'APP_USER');
INSERT INTO `user_roles` (`users_id`, `roles_id`) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(2, 2);
