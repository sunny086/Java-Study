

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_db
-- ----------------------------
DROP TABLE IF EXISTS `user_db`;
CREATE TABLE `user_db`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_db
-- ----------------------------
INSERT INTO `user_db` VALUES (1, '张三');
INSERT INTO `user_db` VALUES (2, '李四');
INSERT INTO `user_db` VALUES (3, '王二');
INSERT INTO `user_db` VALUES (4, '麻子');
INSERT INTO `user_db` VALUES (5, '王三');
INSERT INTO `user_db` VALUES (6, '李三');
INSERT INTO `user_db` VALUES (7, 'hh');

SET FOREIGN_KEY_CHECKS = 1;
