/*
Navicat MySQL Data Transfer

Source Server         : mt
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : message

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-03-23 23:47:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SENDID` int(11) NOT NULL,
  `TITLE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MSGCONTENT` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STATE` int(11) NOT NULL,
  `RECEIVEID` int(11) NOT NULL,
  `MSG_CREATE_DATE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_S_NAME` (`SENDID`),
  KEY `FK_R_NAME` (`RECEIVEID`),
  CONSTRAINT `FK_R_NAME` FOREIGN KEY (`RECEIVEID`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK_S_NAME` FOREIGN KEY (`SENDID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('95', '93', '卡通羽绒棉', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '1', '93', '2020-03-23 23:34:49');
INSERT INTO `message` VALUES ('96', '93', '兔子抱', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '1', '93', '2020-03-23 23:35:24');
INSERT INTO `message` VALUES ('97', '93', '休闲兔毛绒玩具', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '1', '93', '2020-03-23 23:35:38');
INSERT INTO `message` VALUES ('98', '93', '儿童玩偶 ', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '1', '93', '2020-03-23 23:35:52');
INSERT INTO `message` VALUES ('99', '93', '剪刀机公仔', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '1', '93', '2020-03-23 23:36:03');
INSERT INTO `message` VALUES ('100', '93', '礼品批发', '卡通羽绒棉兔子抱枕休闲兔毛绒玩具儿童玩偶 剪刀机公仔 礼品批发', '0', '93', '2020-03-23 23:36:13');
INSERT INTO `message` VALUES ('101', '2', '我是李四', '我是李四我是李四我是李四我是李四我是李四我是李四我是李四我是李四我是李四我是李四', '0', '93', '2018-03-15 04:28:21');
INSERT INTO `message` VALUES ('102', '4', '搞不明白', '搞不明白搞不明白搞不明白搞不明白搞不明白搞不明白搞不明白搞不明白搞不明白搞不明白', '0', '93', '2018-03-15 04:31:58');
INSERT INTO `message` VALUES ('103', '4', '我是陈豪', '我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪我是陈豪', '0', '93', '2018-03-15 04:36:49');
INSERT INTO `message` VALUES ('104', '4', '上海开班信息', '上海开班信息上海开班信息上海开班信息上海开班信息上海开班信息上海开班信息上海开班信息', '1', '93', '2018-03-15 04:59:39');
INSERT INTO `message` VALUES ('105', '4', '中超联赛', '中超联赛中超联赛中超联赛中超联赛中超联赛中超联赛中超联赛中超联赛中超联赛中超联赛', '1', '93', '2018-03-15 05:00:03');
INSERT INTO `message` VALUES ('107', '2', '西甲联赛', '西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛西甲联赛', '0', '93', '2018-03-15 05:00:48');
INSERT INTO `message` VALUES ('108', '2', '英超联赛', '英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛英超联赛', '0', '93', '2018-03-15 05:01:12');
INSERT INTO `message` VALUES ('109', '2', '上海开班信息', '上海总部2018年3月JavaYY12开班计划（上海面授+全国直播）上海总部2018年3月JavaYY12开班计划（上海面授+全国直播）上海总部2018年3月JavaYY12开班计划（上海面授+全国直播）', '0', '93', '2018-03-15 05:15:56');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PWD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'lisi', '038bdaf98f2037b31f1e75b5b4c9b26e', 'lisi@qq.com');
INSERT INTO `user` VALUES ('3', 'wangwu', '038bdaf98f2037b31f1e75b5b4c9b26e', 'wangwu@qq.com');
INSERT INTO `user` VALUES ('4', 'chenhao', '038bdaf98f2037b31f1e75b5b4c9b26e', 'chenhao@qq.com');
INSERT INTO `user` VALUES ('5', 'frankchen', '038bdaf98f2037b31f1e75b5b4c9b26e', 'frankchen@qq.com');
INSERT INTO `user` VALUES ('6', 'mandy', '038bdaf98f2037b31f1e75b5b4c9b26e', 'mandy@qq.com');
INSERT INTO `user` VALUES ('93', 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', '123@qq.com');
