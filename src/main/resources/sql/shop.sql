/*
Navicat MySQL Data Transfer

Source Server         : Gold@localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-03 16:23:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `b_id` varchar(5) NOT NULL,
  `b_name` varchar(255) NOT NULL,
  `b_password` varchar(6) NOT NULL,
  `b_number` varchar(11) NOT NULL,
  `b_sex` varchar(1) NOT NULL,
  `b_mail` varchar(20) DEFAULT NULL,
  `b_address` varchar(255) NOT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('55555', '华南农业大学', '123456', '17876565432', 'm', '2365487979@qq.com', '华南农业大学珠江学院');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `c_id` varchar(23) NOT NULL,
  `u_id` varchar(4) NOT NULL,
  `b_id` varchar(5) NOT NULL,
  `g_id` varchar(6) NOT NULL,
  `c_amount` int(11) NOT NULL,
  `c_price` decimal(10,1) NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `car_ibfk_1` (`u_id`),
  KEY `car_ibfk_2` (`b_id`,`g_id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `car_ibfk_2` FOREIGN KEY (`b_id`, `g_id`) REFERENCES `sell` (`b_id`, `g_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` varchar(6) NOT NULL,
  `g_name` varchar(255) NOT NULL,
  `g_type` varchar(255) NOT NULL,
  `g_price` decimal(10,1) NOT NULL,
  `weight` decimal(10,1) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('123456', '清风抽纸', '日用品', '1231.0', '1.5', 'img/123456.jpg', '金光集团', '123');
INSERT INTO `goods` VALUES ('123457', '洁柔抽纸', '日用品', '23.0', '1.5', 'img/123457.jpg', '卓易隆', '234');
INSERT INTO `goods` VALUES ('134567', '飘柔洗发水', '日用品', '432.0', '500.0', 'img/134567.jpg', '宝洁', '222');
INSERT INTO `goods` VALUES ('234567', '霸王洗发水', '日用品', '234.0', '500.0', 'img/234567.jpg', '霸王国际', '44');
INSERT INTO `goods` VALUES ('543521', '力士沐浴露', '日用品', '423.0', '550.0', 'img/543521.jpg', '力士', '23');
INSERT INTO `goods` VALUES ('765321', '联想电脑', '电子科技', '9999.0', '3.0', 'img/765321.jpg', '联想', '56');
INSERT INTO `goods` VALUES ('765332', 'OPPO N3', '电子科技', '2343.0', '1.5', 'img/765332.jpg', 'OPPO', '111');
INSERT INTO `goods` VALUES ('765431', '凤凰相机', '电子科技', '4567.0', '1.2', 'img/765431.jpg', '凤凰', '99');
INSERT INTO `goods` VALUES ('765432', '小米活塞耳机', '电子科技', '198.0', '1.8', 'img/765432.jpg', '小米', '88');
INSERT INTO `goods` VALUES ('876541', '魔芋爽', '零食小吃', '33.0', '2.2', 'img/876541.jpg', '卫龙', '231');
INSERT INTO `goods` VALUES ('876542', '面筋', '零食小吃', '45.0', '2.0', 'img/876542.jpg', '卫龙', '132');
INSERT INTO `goods` VALUES ('876543', '海带', '零食小吃', '23.0', '1.2', 'img/876543.jpg', '卫龙', '234');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` varchar(25) NOT NULL,
  `u_id` varchar(4) NOT NULL,
  `b_id` varchar(5) NOT NULL,
  `g_id` varchar(6) NOT NULL,
  `o_amount` int(11) NOT NULL,
  `o_price` decimal(10,1) NOT NULL,
  `method` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `u_id` (`u_id`) USING BTREE,
  KEY `b_id` (`b_id`,`g_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`b_id`, `g_id`) REFERENCES `sell` (`b_id`, `g_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2019-08-03-14:15:53123456', '1222', '55555', '123456', '1', '1231.0', '支付宝', '已完成');
INSERT INTO `orders` VALUES ('2019-08-03-14:17:36765332', '1222', '55555', '765332', '3', '2343.0', '支付宝', '已完成');
INSERT INTO `orders` VALUES ('2019-08-03-14:17:37123457', '1222', '55555', '123457', '1', '23.0', '支付宝', '已完成');
INSERT INTO `orders` VALUES ('2019-08-03-14:17:37765321', '1222', '55555', '765321', '2', '9999.0', '支付宝', '已完成');
INSERT INTO `orders` VALUES ('2019-08-03-14:17:37765431', '1222', '55555', '765431', '4', '4567.0', '支付宝', '已完成');
INSERT INTO `orders` VALUES ('2019-08-03-14:18:00134567', '1222', '55555', '134567', '1', '432.0', ' ', '未完成');

-- ----------------------------
-- Table structure for sell
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `b_id` varchar(5) NOT NULL,
  `g_id` varchar(6) NOT NULL,
  PRIMARY KEY (`b_id`,`g_id`),
  KEY `sell_ibfk_2` (`g_id`),
  CONSTRAINT `sell_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `business` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sell_ibfk_2` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('55555', '123456');
INSERT INTO `sell` VALUES ('55555', '123457');
INSERT INTO `sell` VALUES ('55555', '134567');
INSERT INTO `sell` VALUES ('55555', '234567');
INSERT INTO `sell` VALUES ('55555', '543521');
INSERT INTO `sell` VALUES ('55555', '765321');
INSERT INTO `sell` VALUES ('55555', '765332');
INSERT INTO `sell` VALUES ('55555', '765431');
INSERT INTO `sell` VALUES ('55555', '765432');
INSERT INTO `sell` VALUES ('55555', '876541');
INSERT INTO `sell` VALUES ('55555', '876542');
INSERT INTO `sell` VALUES ('55555', '876543');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` varchar(4) NOT NULL,
  `u_name` varchar(255) NOT NULL,
  `u_password` varchar(6) NOT NULL,
  `u_number` varchar(11) NOT NULL,
  `u_sex` varchar(1) NOT NULL,
  `u_mail` varchar(20) DEFAULT NULL,
  `u_address` varchar(255) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1111', 'GG', '123456', '13676565432', 'm', '1098989898@qq.com', '华南农业大学华山区18栋');
INSERT INTO `user` VALUES ('1222', '钟金海', '123456', '13627987854', 'm', '1987676767@qq.com', '华南农业大学泰山区22栋');
INSERT INTO `user` VALUES ('2222', 'DD', '123456', '13767678908', 'w', '1234756565@qq.com', '广东工业大学大学城区22栋');
