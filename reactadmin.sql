/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : reactadmin

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 24/09/2019 16:49:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路由',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组件',
  `sort` int(11) NULL DEFAULT 1 COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `pid` int(11) NOT NULL COMMENT '父id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_link` int(255) NULL DEFAULT 0 COMMENT '是否有路由,0不路由，1有路由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '首页', '/home', 'Home', 1, 'home', 0, '', 1);
INSERT INTO `sys_menu` VALUES (24, '系统管理', '/sys', 'Sys', 1, 'appstore', 0, '', 0);
INSERT INTO `sys_menu` VALUES (25, '用户管理', '/user', 'User', 1, 'user', 24, '', 1);
INSERT INTO `sys_menu` VALUES (26, '菜单管理', '/menu', 'MenuManager', 2, 'menu', 24, '', 1);
INSERT INTO `sys_menu` VALUES (27, '角色管理', '/role', 'Role', 3, 'team', 24, '', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (10, '超级管理员', '', '2019-09-18 17:04:59');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9699 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (9694, 1, 10);
INSERT INTO `sys_role_menu` VALUES (9695, 24, 10);
INSERT INTO `sys_role_menu` VALUES (9696, 25, 10);
INSERT INTO `sys_role_menu` VALUES (9697, 26, 10);
INSERT INTO `sys_role_menu` VALUES (9698, 27, 10);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名',
  `salt` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '加盐',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '1正常0禁用',
  `headimg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `roleid` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `name`(`username`) USING BTREE,
  INDEX `mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (18, 'admin', '', '14e1b600b1fd579f47433b88e8d85291', '', '2019-09-12 13:41:18', 1, 'd93d4e03-4cbc-4917-ae06-286fc4611256.png', 10);

SET FOREIGN_KEY_CHECKS = 1;
