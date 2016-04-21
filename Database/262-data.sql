/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-04-21 16:35:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trips
-- ----------------------------
DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips` (
  `Id` int(11) NOT NULL,
  `Client_Id` int(11) DEFAULT NULL,
  `Driver_Id` int(11) DEFAULT NULL,
  `City_Id` int(11) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Request_at` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of trips
-- ----------------------------
INSERT INTO `trips` VALUES ('1', '1', '10', '1', 'completed', '2013-10-01');
INSERT INTO `trips` VALUES ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01');
INSERT INTO `trips` VALUES ('3', '3', '12', '6', 'completed', '2013-10-01');
INSERT INTO `trips` VALUES ('4', '4', '13', '6', 'cancelled_by_client', '2013-10-01');
INSERT INTO `trips` VALUES ('5', '1', '10', '1', 'completed', '2013-10-02');
INSERT INTO `trips` VALUES ('6', '2', '11', '6', 'completed', '2013-10-02');
INSERT INTO `trips` VALUES ('7', '3', '12', '6', 'completed', '2013-10-02');
INSERT INTO `trips` VALUES ('8', '2', '12', '12', 'completed', '2013-10-03');
INSERT INTO `trips` VALUES ('9', '3', '10', '12', 'completed', '2013-10-03');
INSERT INTO `trips` VALUES ('10', '4', '13', '12', 'cancelled_by_driver', '2013-10-03');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Users_Id` int(11) NOT NULL,
  `Banned` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Users_Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'No', 'client');
INSERT INTO `users` VALUES ('2', 'Yes', 'client');
INSERT INTO `users` VALUES ('3', 'No', 'client');
INSERT INTO `users` VALUES ('4', 'No', 'client');
INSERT INTO `users` VALUES ('10', 'No', 'driver');
INSERT INTO `users` VALUES ('11', 'No', 'driver');
INSERT INTO `users` VALUES ('12', 'No', 'driver');
INSERT INTO `users` VALUES ('13', 'No', 'driver');
