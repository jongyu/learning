/*
Navicat MySQL Data Transfer

Source Server         : Local Host
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-18 19:46:42
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
) ENGINE=InnoDB AUTO_INCREMENT=10030 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of example
-- ----------------------------
INSERT INTO `example` VALUES ('10001', '刘一', '18', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10002', '陈二', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10003', '张三', '25', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10004', '李四', '22', '0', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10005', '王五', '30', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10006', '赵六', '16', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10007', '孙七', '19', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10008', '周八', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10009', '吴九', '23', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10010', '郑十', '24', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10011', '刘一1', '18', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10012', '陈二1', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10013', '张三1', '25', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10014', '李四1', '22', '0', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10015', '王五1', '30', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10016', '赵六1', '16', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10017', '孙七1', '19', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10018', '周八1', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10019', '吴九1', '23', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10020', '刘一2', '18', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10021', '陈二2', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10022', '张三2', '25', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10023', '李四2', '22', '0', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10024', '王五2', '30', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10025', '赵六2', '16', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10026', '孙七2', '19', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10027', '周八2', '20', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10028', '吴九2', '23', '1', '1997-04-18 19:41:47');
INSERT INTO `example` VALUES ('10029', '郑十2', '24', '1', '1997-04-18 19:41:47');
