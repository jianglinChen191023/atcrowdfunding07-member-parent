SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inner_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `inner_admin_role`;
CREATE TABLE `inner_admin_role` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `admin_id` int(11) DEFAULT NULL,
                                    `role_id` int(11) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户和权限中间表';

-- ----------------------------
-- Records of inner_admin_role
-- ----------------------------
BEGIN;
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (1, 2, 2);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (2, 2, 4);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (3, 1, 1);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (4, 1, 3);
INSERT INTO `inner_admin_role` (`id`, `admin_id`, `role_id`) VALUES (5, 7, 5);
COMMIT;

-- ----------------------------
-- Table structure for inner_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `inner_role_auth`;
CREATE TABLE `inner_role_auth` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `role_id` int(11) DEFAULT NULL,
                                   `auth_id` int(11) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色和权限中间表';

-- ----------------------------
-- Records of inner_role_auth
-- ----------------------------
BEGIN;
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (1, 3, 4);
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (2, 4, 6);
INSERT INTO `inner_role_auth` (`id`, `role_id`, `auth_id`) VALUES (3, 4, 3);
COMMIT;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `login_acct` varchar(255) NOT NULL,
                           `user_pswd` varchar(255) NOT NULL,
                           `user_name` varchar(255) NOT NULL,
                           `email` varchar(255) NOT NULL,
                           `create_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
BEGIN;
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (1, 'adminOperator', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '经理', '1@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (2, 'roleOperator', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '部长', '2@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (3, 'admin01', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (4, 'admin02', '2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (5, 'admin03', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '路人甲', '3@qq.com', '2022-08-06 15:50:25');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (6, 'CS3', '$2a$10$elqat0c.KxAlnRV58VOBfuCMboRRNnKG4Qs1bcc4qJDAQTqPLDRTi', '测试3', '1912623646@qq.com', '2022-08-08 01:46:56');
INSERT INTO `t_admin` (`id`, `login_acct`, `user_pswd`, `user_name`, `email`, `create_time`) VALUES (7, 'root', '$2a$10$YlFApwsuOTRxvVlzIKJ1IO20wPftE57QovWuBsKoh2NEYZWKLT6jK', '超级管理员', '0@qq.com', '2022-08-08 03:10:44');
COMMIT;

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(200) DEFAULT NULL,
                          `title` varchar(200) DEFAULT NULL,
                          `category_id` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_auth
-- ----------------------------
BEGIN;
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (1, '', '用户模块', NULL);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (2, 'user:delete', '删除', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (3, 'user:get', '查询', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (4, 'user:save', '保存', 1);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (5, '', '角色模块', NULL);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (6, 'role:delete', '删除', 4);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (7, 'role:get', '查询', 4);
INSERT INTO `t_auth` (`id`, `name`, `title`, `category_id`) VALUES (8, 'role:save', '保存', 4);
COMMIT;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `loginacct` varchar(255) NOT NULL,
                            `userpswd` varchar(255) NOT NULL,
                            `username` varchar(255) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `authstatus` int(4) DEFAULT NULL COMMENT '实名认证状态 [{0: 未实名认证}, {1: 实名认证申请中}, {2: 已实名认证}]',
                            `usertype` int(4) DEFAULT NULL COMMENT '[{0: 个人}, {1: 企业}]',
                            `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
                            `cardnum` varchar(255) DEFAULT NULL COMMENT '卡号',
                            `accttype` int(4) DEFAULT NULL COMMENT '[{0: 企业}, {1: 个体}, {2: 个人}, {3: 政府}]',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `t_member_pk` (`loginacct`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
BEGIN;
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (1, 'jack', '$2a$10$L/7qsHMpVsCRePdhzF7mbuGw2VBCbPd4oOR7I3W6TF04DFHUyb3Qe', '杰克', 'jack@qq.com', 1, 1, '杰克', '430626220104045821', 2);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (5, 'tom', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (6, 'qq', '$2a$10$qX4Dk3KHBnLo.AnkY4ngaeFkn0FBJcX3a3IWmFIjdFsv1rTifePD6', 'user', '123456@qq.com', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (9, 'www', '$2a$10$fiOPIrd3LqtgpGxnAuPbsu0NUoz02RQLomTUCBLmsH/aqSHvDPEqO', 'eav', '123123@qq.com', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_member_confirm_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_confirm_info`;
CREATE TABLE `t_member_confirm_info` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
                                         `paynum` varchar(255) DEFAULT NULL COMMENT '易付宝企业账号',
                                         `cardnum` varchar(255) DEFAULT NULL COMMENT '法人身份证号',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='发起人确认信息表';

-- ----------------------------
-- Records of t_member_confirm_info
-- ----------------------------
BEGIN;
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (1, 1, '24123', '41234123');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (2, 1, '3123432', '31241324');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (3, 1, '4535', '3453453');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (4, 1, 'jack', '123123');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (5, 1, '234234', '23423423423');
INSERT INTO `t_member_confirm_info` (`id`, `memberid`, `paynum`, `cardnum`) VALUES (6, 1, '312312', '123123');
COMMIT;

-- ----------------------------
-- Table structure for t_member_copy1
-- ----------------------------
DROP TABLE IF EXISTS `t_member_copy1`;
CREATE TABLE `t_member_copy1` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `loginacct` varchar(255) NOT NULL,
                                  `userpswd` varchar(255) NOT NULL,
                                  `username` varchar(255) DEFAULT NULL,
                                  `email` varchar(255) DEFAULT NULL,
                                  `authstatus` int(4) DEFAULT NULL COMMENT '实名认证状态 [{0: 未实名认证}, {1: 实名认证申请中}, {2: 已实名认证}]',
                                  `usertype` int(4) DEFAULT NULL COMMENT '[{0: 个人}, {1: 企业}]',
                                  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
                                  `cardnum` varchar(255) DEFAULT NULL COMMENT '卡号',
                                  `accttype` int(4) DEFAULT NULL COMMENT '[{0: 企业}, {1: 个体}, {2: 个人}, {3: 政府}]',
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `t_member_pk` (`loginacct`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member_copy1
-- ----------------------------
BEGIN;
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (1, 'jack', '$2a$10$L/7qsHMpVsCRePdhzF7mbuGw2VBCbPd4oOR7I3W6TF04DFHUyb3Qe', '杰克', 'jack@qq.com', 1, 1, '杰克', '430626220104045821', 2);
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (5, 'tom', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member_copy1` (`id`, `loginacct`, `userpswd`, `username`, `email`, `authstatus`, `usertype`, `realname`, `cardnum`, `accttype`) VALUES (6, 'qq', '$2a$10$qX4Dk3KHBnLo.AnkY4ngaeFkn0FBJcX3a3IWmFIjdFsv1rTifePD6', 'user', '123456@qq.com', NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_member_launch_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_launch_info`;
CREATE TABLE `t_member_launch_info` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `memberid` int(11) DEFAULT NULL COMMENT 't_member 会员标识',
                                        `description_simple` varchar(255) DEFAULT NULL COMMENT '自我介绍',
                                        `description_detail` varchar(255) DEFAULT NULL COMMENT '详细介绍',
                                        `phone_num` varchar(255) DEFAULT NULL COMMENT '联系电话',
                                        `service_num` varchar(255) DEFAULT NULL COMMENT '客服电话',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目发起人信息表';

-- ----------------------------
-- Records of t_member_launch_info
-- ----------------------------
BEGIN;
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (9, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (10, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (11, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (12, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (13, 1, 'i am mao', '我是猫哥', '123456', '654321');
INSERT INTO `t_member_launch_info` (`id`, `memberid`, `description_simple`, `description_detail`, `phone_num`, `service_num`) VALUES (14, 1, 'i am mao', '我是猫哥', '123456', '654321');
COMMIT;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `pid` int(11) DEFAULT NULL,
                          `name` varchar(200) DEFAULT NULL,
                          `url` varchar(200) DEFAULT NULL,
                          `icon` varchar(200) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (1, NULL, '系统权限菜单', NULL, 'glyphicon glyphicon-th-list');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (2, 1, ' 控 制 面 板 ', 'main.htm', 'glyphicon glyphicon-dashboard');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (3, 1, '权限管理', NULL, 'glyphicon glyphicon glyphicon-tasks');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (4, 3, ' 用 户 维 护 ', 'user/index.htm', 'glyphicon glyphicon-user');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (5, 3, ' 角 色 维 护 ', 'role/index.htm', 'glyphicon glyphicon-king');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (6, 3, ' 菜 单 维 护 ', 'permission/index.htm', 'glyphicon glyphicon-lock');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (7, 1, ' 业 务 审 核 ', NULL, 'glyphicon glyphicon-ok');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (8, 7, ' 实 名 认 证 审 核 ', 'auth_cert/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (9, 7, ' 广 告 审 核 ', 'auth_adv/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (10, 7, ' 项 目 审 核 ', 'auth_project/index.htm', 'glyphicon glyphicon-check');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (11, 1, ' 业 务 管 理 ', NULL, 'glyphicon glyphicon-th-large');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (12, 11, ' 资 质 维 护 ', 'cert/index.htm', 'glyphicon glyphicon-picture');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (13, 11, ' 分 类 管 理 ', 'certtype/index.htm', 'glyphicon glyphicon-equalizer');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (14, 11, ' 流 程 管 理 ', 'process/index.htm', 'glyphicon glyphicon-random');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (15, 11, ' 广 告 管 理 ', 'advert/index.htm', 'glyphicon glyphicon-hdd');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (16, 11, ' 消 息 模 板 ', 'message/index.htm', 'glyphicon glyphicon-comment');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (17, 11, ' 项 目 分 类 ', 'projectType/index.htm', 'glyphicon glyphicon-list');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (18, 11, ' 项 目 标 签 ', 'tag/index.htm', 'glyphicon glyphicon-tags');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (19, 1, ' 参 数 管 理 ', 'param/index.htm', 'glyphicon glyphicon-list-alt');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `url`, `icon`) VALUES (20, 1, 'A', 'A', 'glyphicon glyphicon-list-alt');
COMMIT;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
                             `project_description` varchar(255) DEFAULT NULL COMMENT '项目描述',
                             `money` bigint(11) DEFAULT NULL COMMENT '筹集金额',
                             `day` int(11) DEFAULT NULL COMMENT '筹集天数',
                             `status` int(4) DEFAULT NULL COMMENT '[{0: 审核中}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]',
                             `deploydate` varchar(255) DEFAULT NULL COMMENT '项目发起时间',
                             `supportmoney` bigint(11) DEFAULT NULL COMMENT '已筹集到的金额',
                             `supporter` int(11) DEFAULT NULL COMMENT '支持人数',
                             `completion` int(3) DEFAULT NULL COMMENT '百分比完成度',
                             `memberid` int(11) DEFAULT NULL COMMENT '发起人的会员标识',
                             `createdate` varchar(19) DEFAULT NULL COMMENT '项目创建时间',
                             `follower` int(11) DEFAULT NULL COMMENT '关注人数',
                             `header_picture_path` varchar(255) DEFAULT NULL COMMENT '头图路径',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of t_project
-- ----------------------------
BEGIN;
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (15, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 1, 11, 1, '2022-09-03', 11, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (16, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 2, 11, 1, '2022-09-03', 12, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (17, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 3, 11, 1, '2022-09-03', 13, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (18, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 4, 11, 1, '2022-09-03', 14, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (19, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-01', 11, 5, 11, 1, '2022-09-03', 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
INSERT INTO `t_project` (`id`, `project_name`, `project_description`, `money`, `day`, `status`, `deploydate`, `supportmoney`, `supporter`, `completion`, `memberid`, `createdate`, `follower`, `header_picture_path`) VALUES (20, 'brotherMao', '就是帅！', 100, 30, 0, '2022-09-04', 11, 6, 11, 1, '2022-09-04', 16, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/4fcaa821-f0b7-46f8-aebc-825bb1e208b2.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_project_item_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_project_item_pic`;
CREATE TABLE `t_project_item_pic` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
                                      `item_pic_path` varchar(255) DEFAULT NULL COMMENT '图片名称',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目表项目详情图片表';

-- ----------------------------
-- Records of t_project_item_pic
-- ----------------------------
BEGIN;
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (9, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (10, 16, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (11, 17, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (12, 18, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (13, 19, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
INSERT INTO `t_project_item_pic` (`id`, `projectid`, `item_pic_path`) VALUES (14, 20, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/deb8461d-cdb4-4652-9aed-096a63671bdb.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_project_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_project_tag`;
CREATE TABLE `t_project_tag` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
                                 `tagid` int(11) DEFAULT NULL COMMENT 't_tag 标识',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='项目标签中间表';

-- ----------------------------
-- Records of t_project_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (19, 15, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (20, 15, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (21, 16, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (22, 16, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (23, 17, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (24, 17, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (25, 17, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (26, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (27, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (28, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (29, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (30, 18, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (31, 18, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (32, 19, 4);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (33, 19, 7);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (34, 19, 9);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (35, 20, 6);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (36, 20, 8);
INSERT INTO `t_project_tag` (`id`, `projectid`, `tagid`) VALUES (37, 20, 10);
COMMIT;

-- ----------------------------
-- Table structure for t_project_type
-- ----------------------------
DROP TABLE IF EXISTS `t_project_type`;
CREATE TABLE `t_project_type` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `projectid` int(11) DEFAULT NULL COMMENT 't_project 标识',
                                  `typeid` int(11) DEFAULT NULL COMMENT 't_type 标识',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='项目和分类中间表';

-- ----------------------------
-- Records of t_project_type
-- ----------------------------
BEGIN;
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (29, 15, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (30, 15, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (31, 16, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (32, 16, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (33, 17, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (34, 17, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (35, 18, 2);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (36, 18, 4);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (37, 19, 1);
INSERT INTO `t_project_type` (`id`, `projectid`, `typeid`) VALUES (38, 20, 3);
COMMIT;

-- ----------------------------
-- Table structure for t_return
-- ----------------------------
DROP TABLE IF EXISTS `t_return`;
CREATE TABLE `t_return` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `projectid` int(11) DEFAULT NULL COMMENT 't_projcet 项目标识',
                            `type` int(4) DEFAULT NULL COMMENT '[{0: 实物回报}, {1: 虚拟物品回报}]',
                            `supportmoney` int(11) DEFAULT NULL COMMENT '支持金额',
                            `content` varchar(255) DEFAULT NULL COMMENT '回报内容',
                            `count` int(11) DEFAULT NULL COMMENT '回报产品限额 {0: 不限额回报数量}',
                            `signalpurchase` int(11) DEFAULT NULL COMMENT '是否设置单笔限购',
                            `purchase` int(11) DEFAULT NULL COMMENT '具体限购数量',
                            `freight` int(11) DEFAULT NULL COMMENT '运费 {0: 包邮}',
                            `invoice` int(4) DEFAULT NULL COMMENT '[{0: 不开发票}, {1: 开发票}]',
                            `returndate` int(11) DEFAULT NULL COMMENT '项目结束后多少天向支持者发送回报',
                            `describ_pic_path` varchar(255) DEFAULT NULL COMMENT '说明图片路径',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='回报信息表';

-- ----------------------------
-- Records of t_return
-- ----------------------------
BEGIN;
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (1, 15, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (2, 16, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (3, 17, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (4, 18, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (5, 19, 0, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
INSERT INTO `t_return` (`id`, `projectid`, `type`, `supportmoney`, `content`, `count`, `signalpurchase`, `purchase`, `freight`, `invoice`, `returndate`, `describ_pic_path`) VALUES (6, 20, 1, 10, '以身相许', 5, 1, 8, 0, 1, 15, 'https://atguigu220827.oss-cn-guangzhou.aliyuncs.com/20220904/56c4d3ca-cb1f-4cfb-9bff-64fec98e131b.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色 ID',
                          `name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` (`id`, `name`) VALUES (1, '经理');
INSERT INTO `t_role` (`id`, `name`) VALUES (2, '部长');
INSERT INTO `t_role` (`id`, `name`) VALUES (3, '经理操作者');
INSERT INTO `t_role` (`id`, `name`) VALUES (4, '部长操作者');
INSERT INTO `t_role` (`id`, `name`) VALUES (5, 'Admin');
COMMIT;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `pid` int(11) DEFAULT NULL,
                         `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (1, NULL, '手机');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (2, NULL, '数码');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (3, NULL, '电脑');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (4, 1, '大屏');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (5, 1, '美颜');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (6, 1, '续航');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (7, 2, '高解析度');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (8, 2, '高清');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (9, 3, '大内存');
INSERT INTO `t_tag` (`id`, `pid`, `name`) VALUES (10, 3, '固态');
COMMIT;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
                          `remark` varchar(255) DEFAULT NULL COMMENT '分类说明',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of t_type
-- ----------------------------
BEGIN;
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (1, '科技', '开启科技未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (2, '设计', '创建改变未来');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (3, '公益', '汇集点点爱心');
INSERT INTO `t_type` (`id`, `name`, `remark`) VALUES (4, '农业', '网络天下肥美');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
