/*
Navicat MySQL Data Transfer

Source Server         : Local Host
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-29 21:00:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of example
-- ----------------------------
INSERT INTO `example` VALUES ('1', '刘一', '17', 'MALE', '2017-03-29 08:48:11');
INSERT INTO `example` VALUES ('2', '陈二', '20', 'MALE', '2017-03-29 08:48:14');
INSERT INTO `example` VALUES ('3', '张三', '18', 'MALE', '2017-03-29 08:48:16');
INSERT INTO `example` VALUES ('4', '李四', '19', 'MALE', '2017-03-29 08:48:18');
INSERT INTO `example` VALUES ('5', '王五', '20', 'MALE', '2017-03-29 08:48:20');
INSERT INTO `example` VALUES ('6', '赵六', '16', 'MALE', '2017-03-29 08:48:23');
INSERT INTO `example` VALUES ('7', '孙七', '18', 'MALE', '2017-03-29 08:48:26');
INSERT INTO `example` VALUES ('8', '周八', '18', 'MALE', '2017-03-29 08:48:28');
INSERT INTO `example` VALUES ('9', '吴九', '20', 'MALE', '2017-03-29 08:48:31');
INSERT INTO `example` VALUES ('10','郑十', '20', 'MALE', '2017-03-29 08:48:34');
