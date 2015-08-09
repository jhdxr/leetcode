/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-08-10 00:48:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'IT');
INSERT INTO `department` VALUES ('2', 'Sales');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Salary` int(11) NOT NULL,
  `DepartmentId` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Joe', '70000', '1');
INSERT INTO `employee` VALUES ('2', 'Henry', '80000', '2');
INSERT INTO `employee` VALUES ('3', 'Sam', '60000', '2');
INSERT INTO `employee` VALUES ('4', 'Max', '90000', '1');
INSERT INTO `employee` VALUES ('5', 'Janet', '69000', '1');
INSERT INTO `employee` VALUES ('6', 'Randy', '85000', '1');
INSERT INTO `employee` VALUES ('7', 'Tom', '85000', '1');
