/*
Navicat MySQL Data Transfer

Source Server         : mysql5123
Source Server Version : 50735
Source Host           : localhost:3306
Source Database       : boot

Target Server Type    : MYSQL
Target Server Version : 50735
File Encoding         : 65001

Date: 2021-11-24 22:44:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tablea
-- ----------------------------
DROP TABLE IF EXISTS `tablea`;
CREATE TABLE `tablea` (
  `id` int(11) NOT NULL,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tableb
-- ----------------------------
DROP TABLE IF EXISTS `tableb`;
CREATE TABLE `tableb` (
  `id` int(11) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_departs
-- ----------------------------
DROP TABLE IF EXISTS `t_departs`;
CREATE TABLE `t_departs` (
  `depart_id` varchar(4) DEFAULT NULL,
  `depart_name` varchar(8) DEFAULT NULL,
  `manager` varchar(8) DEFAULT NULL,
  `id` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_employ
-- ----------------------------
DROP TABLE IF EXISTS `t_employ`;
CREATE TABLE `t_employ` (
  `employId` varchar(8) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `departId` varchar(8) DEFAULT NULL,
  `position` varchar(12) DEFAULT NULL,
  `id` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Procedure structure for getById
-- ----------------------------
DROP PROCEDURE IF EXISTS `getById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getById`(in uid varchar(8))
begin
 
select id,name,partment,position from t_employ where id=uid;
 
end
;;
DELIMITER ;
