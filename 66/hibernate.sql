/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : hibernate

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 09/09/2021 09:10:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_pur_approval
-- ----------------------------
DROP TABLE IF EXISTS `tbl_pur_approval`;
CREATE TABLE `tbl_pur_approval`  (
  `paId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `paDate` date DEFAULT NULL,
  `paState` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`paId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_pur_approval
-- ----------------------------
INSERT INTO `tbl_pur_approval` VALUES (1, 1, '2021-09-08', '已审批');
INSERT INTO `tbl_pur_approval` VALUES (2, 2, '2021-09-22', '已审批');
INSERT INTO `tbl_pur_approval` VALUES (3, 3, '2021-09-08', '已审批');
INSERT INTO `tbl_pur_approval` VALUES (4, 4, '2021-09-15', '已审批');

-- ----------------------------
-- Table structure for tbl_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tbl_purchase`;
CREATE TABLE `tbl_purchase`  (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `pType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pNum` int(11) DEFAULT NULL,
  `pPerson` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`pId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_purchase
-- ----------------------------
INSERT INTO `tbl_purchase` VALUES (1, '办公用品', '笔记本', '台', 6, '小明');
INSERT INTO `tbl_purchase` VALUES (2, '用品', '盒子', '台', 3, '小黑');
INSERT INTO `tbl_purchase` VALUES (3, '办公用品', 'A4纸', '张', 200, '小黑');
INSERT INTO `tbl_purchase` VALUES (4, '办公用品', 'aa纸', '张三', 20, '小黑');
INSERT INTO `tbl_purchase` VALUES (5, '办公用品', 'aa纸', '张三', 20, '小黑');
INSERT INTO `tbl_purchase` VALUES (6, 'budahs', 'asdsdas', 'csd', 12, 'dassda');
INSERT INTO `tbl_purchase` VALUES (7, 'budahs', 'asdsdas', 'csd', 12, 'dassda');
INSERT INTO `tbl_purchase` VALUES (8, 'ss', 'ss', 'ss', 12, '1');

SET FOREIGN_KEY_CHECKS = 1;
