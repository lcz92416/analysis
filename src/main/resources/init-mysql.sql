SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'temp', 'temp');

SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');

SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL,
  `Sys_User_id` int(11) NOT NULL,
  `Sys_Role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Sys_User_id` (`Sys_User_id`),
  KEY `Sys_Role_id` (`Sys_Role_id`),
  CONSTRAINT `Sys_Role_id` FOREIGN KEY (`Sys_Role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `Sys_User_id` FOREIGN KEY (`Sys_User_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');
