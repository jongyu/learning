
-- ---------------------------
-- Table structure for example
-- ---------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ---------------------------
-- Records of example
-- ---------------------------
INSERT INTO `example` VALUES ('1', 'zhangsan');
