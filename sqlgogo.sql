/*
Navicat MySQL Data Transfer

Source Server         : centos
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : sqlgogo

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-09 11:09:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  `teacherName` varchar(255) DEFAULT NULL,
  `studentsNumber` int(11) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `teaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('2', '17软本四', '康瑶', '22', '2018-09-21 20:23:33', '2');
INSERT INTO `classinfo` VALUES ('3', '18软本五', '康瑶', '34', '2018-09-21 20:23:56', '2');
INSERT INTO `classinfo` VALUES ('4', '18软本一', '石明翔', '5', '2018-09-14 22:11:12', null);
INSERT INTO `classinfo` VALUES ('25', '17软本4', '曾智琴', '44', '2019-03-25 20:21:44', '1');
INSERT INTO `classinfo` VALUES ('27', '18软本4', '曾智琴', '22', '2018-09-20 13:13:04', '1');
INSERT INTO `classinfo` VALUES ('30', '二班', '曾智琴', '13', '2018-09-20 21:06:10', '1');
INSERT INTO `classinfo` VALUES ('34', '16软本2', '曾智琴', '32', '2019-03-25 19:21:02', '1');
INSERT INTO `classinfo` VALUES ('35', '16软本3', '曾智琴', '22', '2019-03-20 19:22:03', '1');
INSERT INTO `classinfo` VALUES ('36', '16软本4', '曾智琴', '34', '2019-03-29 19:22:08', '1');
INSERT INTO `classinfo` VALUES ('37', '15软本2', '曾智琴', '33', '2019-03-25 20:24:02', '1');
INSERT INTO `classinfo` VALUES ('43', '白蛇班2', '曾智琴', '40', '2019-04-10 15:55:20', '1');
INSERT INTO `classinfo` VALUES ('44', '青蛇班', '曾智琴', '2', '2019-04-10 15:56:59', '1');

-- ----------------------------
-- Table structure for dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `dbinfo`;
CREATE TABLE `dbinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbname` varchar(255) DEFAULT NULL,
  `creattime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tea_user` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dbinfo
-- ----------------------------
INSERT INTO `dbinfo` VALUES ('22', 'libbms4', '2019-03-24 18:08:37', '16111651227');
INSERT INTO `dbinfo` VALUES ('23', 'libbms5', '2019-03-24 18:11:27', '16111651227');
INSERT INTO `dbinfo` VALUES ('24', 'libbms', '2019-04-09 21:54:38', '16111651227');
INSERT INTO `dbinfo` VALUES ('28', 'test', '2019-04-28 13:38:30', '16111651227');

-- ----------------------------
-- Table structure for pra_sub
-- ----------------------------
DROP TABLE IF EXISTS `pra_sub`;
CREATE TABLE `pra_sub` (
  `pra_Id` int(11) NOT NULL,
  `sub_id` varchar(255) DEFAULT NULL,
  `deleted` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pra_sub
-- ----------------------------
INSERT INTO `pra_sub` VALUES ('2', '1', '1');
INSERT INTO `pra_sub` VALUES ('2', '2', '1');
INSERT INTO `pra_sub` VALUES ('28', '1', '1');
INSERT INTO `pra_sub` VALUES ('28', '7', '1');
INSERT INTO `pra_sub` VALUES ('28', '9', '1');
INSERT INTO `pra_sub` VALUES ('28', '10', '1');
INSERT INTO `pra_sub` VALUES ('1', '1', '1');
INSERT INTO `pra_sub` VALUES ('1', '2', '1');
INSERT INTO `pra_sub` VALUES ('1', '7', '1');
INSERT INTO `pra_sub` VALUES ('1', '8', '1');

-- ----------------------------
-- Table structure for practice
-- ----------------------------
DROP TABLE IF EXISTS `practice`;
CREATE TABLE `practice` (
  `PracticeId` int(11) NOT NULL AUTO_INCREMENT,
  `PracticeName` varchar(255) DEFAULT NULL,
  `dbname` varchar(255) DEFAULT NULL,
  `ClassName` varchar(255) DEFAULT NULL,
  `PracticeGenre` varchar(255) DEFAULT NULL,
  `PublishDay` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Deadline` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT '1',
  `ques_id` int(11) DEFAULT NULL,
  `result_portion` int(11) DEFAULT NULL,
  `process_portion` int(11) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  PRIMARY KEY (`PracticeId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practice
-- ----------------------------
INSERT INTO `practice` VALUES ('1', '第一次练习', 'eighting', '18软本4', '数据库课程设计', '2018-10-09 22:22:16', '2019-04-27 23:43:25', '1', '16', '2', '8', '27');
INSERT INTO `practice` VALUES ('2', '第二次练习', 'eighting', '18软本4', '数据库课程设计', '2018-10-09 22:23:20', '2018-10-18 22:23:24', '1', '16', '1', '9', '27');
INSERT INTO `practice` VALUES ('3', '第三次练习', 'eighting', '17软本1', '数据库课程设计', '2018-10-23 14:47:07', '2018-10-25 14:47:10', '1', '17', '9', '1', '27');
INSERT INTO `practice` VALUES ('4', '第四次', 'eighting', '18软本4', '数据库课程设计', '2018-10-01 02:12:56', '2018-10-22 02:13:00', '1', '18', '8', '2', '27');
INSERT INTO `practice` VALUES ('5', '第五次', 'test', '18软本4', '数据库课程设计', '2018-10-01 23:04:35', '2018-10-23 23:04:40', '1', '19', '6', '4', '27');
INSERT INTO `practice` VALUES ('6', '第六次', 'eighting', '18软本4', '数据库课程设计', '2018-10-18 17:21:16', '2018-10-25 17:21:21', '1', '20', '5', '5', '27');
INSERT INTO `practice` VALUES ('20', '23213', null, '软本1', '高级数据库', '2019-03-20 10:32:23', '2019-03-20 10:31:24', '1', '7', '1', '9', '27');
INSERT INTO `practice` VALUES ('21', '1', null, '软本1', '数据库设计', '2019-03-20 10:32:31', '2019-03-20 10:32:30', '1', '6', '1', '9', '27');
INSERT INTO `practice` VALUES ('22', '但是', 'eighting', '软本2', '高级数据库', '2019-03-20 10:37:42', '2019-03-20 10:37:38', '1', '7', '1', '9', '27');
INSERT INTO `practice` VALUES ('23', '213123', 'newdb', '二班', '数据库原理', '2019-03-20 10:54:15', '2019-03-20 10:54:05', '1', '6', '1', '9', null);
INSERT INTO `practice` VALUES ('24', '说到底', 'eighting', '17软本四', '数据库原理', '2019-03-20 11:02:59', '2019-03-20 11:02:55', '1', '7', '1', '9', '2');
INSERT INTO `practice` VALUES ('25', '测试练习1', 'eighting', '16软本2', '数据库原理', '2019-04-24 20:39:28', '1979-09-19 05:45:07', '1', '24', '8', '2', '34');
INSERT INTO `practice` VALUES ('26', '测试2', 'eighting', '16软本2', '数据库原理', '2019-04-24 20:41:29', '2019-04-24 20:41:15', '1', '24', '2', '8', '34');
INSERT INTO `practice` VALUES ('27', 'da', 'test1', '16软本2', '高级数据库', '2019-04-24 22:28:26', '2020-12-27 05:30:07', '1', '25', '2', '8', '34');
INSERT INTO `practice` VALUES ('28', '88', 'eighting', '17软本四', '数据库原理', '2019-04-26 08:40:10', '2019-08-29 16:50:07', '1', '24', '7', '3', '2');
INSERT INTO `practice` VALUES ('29', '大萨达', 'libbms', '17软本四', '数据库原理', '2019-04-27 23:36:30', '2019-04-27 23:36:28', '1', '24', '1', '9', '2');
INSERT INTO `practice` VALUES ('30', '测试练习', 'libbms', '18软本五', '数据库原理', '2019-04-28 11:05:39', '2019-04-28 11:05:19', '1', '24', '1', '9', '3');

-- ----------------------------
-- Table structure for ques
-- ----------------------------
DROP TABLE IF EXISTS `ques`;
CREATE TABLE `ques` (
  `quename` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quecontext` varchar(255) DEFAULT NULL,
  `belongto` varchar(255) DEFAULT NULL,
  `thedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ques
-- ----------------------------
INSERT INTO `ques` VALUES ('宿舍管理系统', '15', '方便管理宿舍', null, '2018-10-13 11:03:20');
INSERT INTO `ques` VALUES ('eighting', '16', '一个上课用的库', null, '2018-10-03 13:49:52');
INSERT INTO `ques` VALUES ('斐波猎奇数列', '17', '测试用的', null, '2018-10-24 20:47:47');
INSERT INTO `ques` VALUES ('一个系统', '18', '描述', null, '2018-10-25 13:30:29');
INSERT INTO `ques` VALUES ('皇家管理系统', '19', '描述', null, '2018-10-25 13:30:29');
INSERT INTO `ques` VALUES ('后宫管理系统', '20', '描述', null, '2018-10-25 13:30:29');
INSERT INTO `ques` VALUES ('嘿嘿', '21', '234', null, '2019-03-22 20:13:14');
INSERT INTO `ques` VALUES ('哈哈', '22', '是否啥', null, '2019-04-10 16:25:28');
INSERT INTO `ques` VALUES ('哟哟哟', '26', '撒发顺丰', null, '2019-03-28 20:35:12');
INSERT INTO `ques` VALUES ('方法都是', '28', '顺丰到付是', null, '2019-03-28 20:36:08');
INSERT INTO `ques` VALUES ('加一个', '50', '加点啥', null, '2019-03-29 16:59:14');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `QuestionId` int(30) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `studentsNumber` int(255) DEFAULT NULL,
  `addtime` timestamp NULL DEFAULT NULL,
  `questionProtray` varchar(500) DEFAULT NULL,
  `questionDeal` varchar(255) DEFAULT NULL,
  `star` int(11) DEFAULT '0',
  `concern` int(11) DEFAULT '0',
  `deleted` int(11) DEFAULT '1',
  `filepath` varchar(255) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`QuestionId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '17软本三', '刘强东', '2', '2018-09-05 16:25:50', '我是真的不会做啊', '你好', '1', '30', '1', '../../SQLgogo2/student/upload/img/LQD.png', '哎哎哎');
INSERT INTO `questions` VALUES ('2', '18软本四', '胡歌', '3', '2018-09-12 16:26:25', '但事实上大所大所大所大所多', '0', '1', '30', '1', '../../SQLgogo2/student/upload/img/HG.png', '嗷嗷嗷');
INSERT INTO `questions` VALUES ('3', '16软本一', '章泽天', '4', '2018-09-12 16:26:45', '打首饰的撒大所多撒多', '0', '1', '10', '1', 'pics/xiong.jpg', '哎哎哎');
INSERT INTO `questions` VALUES ('4', '15软本二', '胡歌', '3', '2018-09-19 16:27:14', '的得得得得得得得多多多多多', '0', '1', '5', '1', 'pics/NN.jpg', '啊啊啊');
INSERT INTO `questions` VALUES ('15', '18软本4', '杨幂', '1', '2019-03-31 22:19:41', '打打', '0', '0', '0', '1', '../../SQLgogo2/student/upload/img/1553930290207.png', '大师');
INSERT INTO `questions` VALUES ('18', '18软本4', '杨幂', '1', '2019-04-02 13:21:38', '大萨达我的', '0', '1', '0', '1', '../../SQLgogo2/student/upload/img/1553930290207.png', '大萨达');
INSERT INTO `questions` VALUES ('20', '18软本4', '杨幂', '1', '2019-04-26 10:56:32', 'dasdas', null, '0', '0', '1', '../../SQLgogo2/student//sqlgogo_stu/1556241072855_013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg', 'dasd');
INSERT INTO `questions` VALUES ('21', '18软本4', '杨幂', '1', '2019-04-28 11:21:52', '测试', '0', '0', '0', '1', '../../SQLgogo2/student//sqlgogo_stu/1556421581760_u=3073374472,3704735950&fm=26&gp=0.jpg', '测试');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pra_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `pro_score` int(11) DEFAULT NULL,
  `res_score` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `code` varchar(1000) DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('2', '1', '1', '1', '27', '6', '0', '6', ' select * from empt;', '2019-04-10 16:06:21');
INSERT INTO `result` VALUES ('3', '1', '1', '5', '27', '17', '93', '100', ' ', '2019-04-28 14:43:28');
INSERT INTO `result` VALUES ('4', '1', '3', '1', '27', '6', '0', '6', ' select * from emp;', '2019-04-09 15:06:10');

-- ----------------------------
-- Table structure for stuuser
-- ----------------------------
DROP TABLE IF EXISTS `stuuser`;
CREATE TABLE `stuuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ClassId` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `classname` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `phone_num` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `last_pro_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuuser
-- ----------------------------
INSERT INTO `stuuser` VALUES ('1', '27', '16111651228', '111', '杨幂', '18软本4', '939129504@qq.com', '18210915622', '女', '表演事业', '嘉行影业', '/sqlgogo_stu/1556430404954_013f5958c53a47a801219c772a5335.jpg@900w_1l_2o_100sh.jpg', '2019-04-28 11:21:52');
INSERT INTO `stuuser` VALUES ('2', '30', '16111651226', '111', '刘强东', '二班', '939129504@qq.com', '18210915622', '男', '工商管理', '老总', '/sqlgogo_stu/1556209705596_timg.jpg', null);
INSERT INTO `stuuser` VALUES ('3', '27', '16111651211', '111', '胡歌', '18软本4', '939129504@qq.com', '18210915622', '男', '工商管理', '老总', '../../upload_stu/img/1556092942106.jpg', null);
INSERT INTO `stuuser` VALUES ('4', '25', '16111651212', '111', '章泽天', '18软本三', null, null, null, null, null, '/sqlgogo_stu/1556206698708_240450-140HZP45790.jpg', null);
INSERT INTO `stuuser` VALUES ('5', '25', '16111651240', '111', '苏明达', '18软本三', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('6', '27', '16111645332', '111', '张杰', '中戏1班', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('7', '25', '16111632322', '111', '谢娜', '北影二班', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('8', '27', '16111645301', '16111645301', '紫薇', '中戏1班', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('9', '25', '16111651229', null, '海王', '17软本4', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('10', '25', '16111651222', '16111651222', '林品如', '17软本4', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('45', '25', '16111651920', '16111651920', '路招摇', '17软本4', null, null, null, null, null, null, null);
INSERT INTO `stuuser` VALUES ('46', '27', 'dasd', 'dasd', 'dsadas', '18软本4', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for subjects
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `SubjectId` int(11) NOT NULL AUTO_INCREMENT,
  `SubjectName` varchar(255) NOT NULL,
  `Scores` int(11) DEFAULT NULL COMMENT '结果得分',
  `ExamScores` int(11) DEFAULT NULL COMMENT '过程得分',
  `Total` int(11) DEFAULT NULL,
  `Method` varchar(255) DEFAULT '不知道',
  `deleted` int(11) DEFAULT '1',
  `subject_detail` varchar(255) DEFAULT NULL,
  `subject_answer` varchar(255) DEFAULT NULL,
  `ques_id` int(11) DEFAULT '-1',
  `key_choice` varchar(255) DEFAULT NULL,
  `set_score` int(11) DEFAULT NULL,
  `setpro_score` int(11) DEFAULT NULL,
  `setres_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`SubjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjects
-- ----------------------------
INSERT INTO `subjects` VALUES ('1', '图书阿里哈哈', '0', '12', '100', '不知道', '1', '查找dept表中所有数据', 'select * from dept;', '15', 'select,', '100', '20', '80');
INSERT INTO `subjects` VALUES ('2', '图书阿里2', '10', '10', '100', '不知道', '1', '查找dept为10的deptno', '哈哈哈', '15', 'and,join', '100', '20', '80');
INSERT INTO `subjects` VALUES ('3', '图书阿里3', '1', '1', '100', '不知道', '1', '查找deptno为20的人的empno', 'select * from dept;', '14', 'and,join,select,', '100', '20', '80');
INSERT INTO `subjects` VALUES ('4', '图书阿里4', '1', '2', '100', '不知道', '1', '查找mydb1表的deptno表中所有数据', '哈哈哈', '14', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('5', '图书阿里5', '1', '1', '100', '不知道', '1', '查找deptno为20的人的empno', '哈哈哈', '20', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('6', '大萨达', null, null, null, '不知道', '0', '大萨', '达', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('7', '第nnn次联系', null, null, null, '不知道', '1', '的撒打算的', '都是ddddddd', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('8', '不是太懂', null, null, null, '不知道', '1', '啊啊啊啊啊', '打算的撒大大多', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('9', '大萨', null, null, null, '不知道', '1', '221312', '打打', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('10', '3213', null, null, null, '不知道', '1', '23213', '222222', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('11', '打算的撒大大多', null, null, null, '不知道', '1', '大萨达', '大萨大萨大萨达', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('12', '打打', null, null, null, '不知道', '1', '22222', '233333', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('13', '大萨大萨大萨达', null, null, null, '不知道', '1', '速度的地地道道的', '上213123213', '15', null, '100', '20', '80');
INSERT INTO `subjects` VALUES ('15', '大幂幂美不美', null, null, '100', '不知道', '1', '肤白貌美大长腿', '美炸了', '15', 'select,where,', null, null, null);
INSERT INTO `subjects` VALUES ('16', '大幂幂美丽系列', null, null, '100', '不知道', '1', '2', '美丽', '15', 'select,', null, null, null);
INSERT INTO `subjects` VALUES ('44', '自定义', null, null, '100', '不知道', '1', '自定义', '自定义', '-1', 'select,from,', null, null, null);

-- ----------------------------
-- Table structure for subjects_self
-- ----------------------------
DROP TABLE IF EXISTS `subjects_self`;
CREATE TABLE `subjects_self` (
  `Subject_self_Id` int(11) NOT NULL AUTO_INCREMENT,
  `PracticeId` int(11) DEFAULT NULL,
  `Subject_self_Name` varchar(255) DEFAULT NULL,
  `Scores` int(11) DEFAULT NULL,
  `ExamScores` int(11) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL,
  `Method` varchar(255) DEFAULT '不知道',
  `deleted` int(11) DEFAULT '1',
  `subject_detail` varchar(255) DEFAULT NULL,
  `subject_answer` varchar(255) DEFAULT NULL,
  `ques_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Subject_self_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjects_self
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for teaquestions
-- ----------------------------
DROP TABLE IF EXISTS `teaquestions`;
CREATE TABLE `teaquestions` (
  `teaQuestionId` int(30) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  `teaName` varchar(255) DEFAULT '康瑶',
  `teaNumber` int(11) DEFAULT '1',
  `addtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `questionProtray` varchar(500) DEFAULT NULL,
  `questionDeal` varchar(255) DEFAULT NULL,
  `star` int(11) DEFAULT '0',
  `concern` int(11) DEFAULT '0',
  `deleted` int(11) DEFAULT '1',
  `qesName` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teaQuestionId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaquestions
-- ----------------------------
INSERT INTO `teaquestions` VALUES ('1', '数据库基础', '康瑶', '3', '2018-10-25 15:18:40', '同学们基础的数据库查询语句都懂了吗', '稍后发布', '20', '20', '1', '数据库基础', null);
INSERT INTO `teaquestions` VALUES ('2', '数据库高级', '石明翔', '2', '2018-10-08 15:19:50', '同学们基础的数据库高级查询语句都懂了吗', '稍后发布', '50', '10', '1', '数据库高级', null);
INSERT INTO `teaquestions` VALUES ('3', '数据库基础', '康瑶', '3', '2018-10-20 15:18:40', '同学们基础的数据库高级查询语句都懂', '稍后发布', '333', '30', '1', '数据库基础', null);
INSERT INTO `teaquestions` VALUES ('4', null, '曾智琴', '1', '2019-04-08 22:14:53', '大大声道', null, '0', '0', '1', '大萨达', null);
INSERT INTO `teaquestions` VALUES ('22', null, '曾智琴', '1', '2019-04-28 13:16:46', '写了', null, '0', '0', '1', '数据库作业写了吗', null);

-- ----------------------------
-- Table structure for teauser
-- ----------------------------
DROP TABLE IF EXISTS `teauser`;
CREATE TABLE `teauser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` bigint(20) NOT NULL,
  `password` bigint(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `e_mail` varchar(30) DEFAULT NULL,
  `phone_num` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `profile` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of teauser
-- ----------------------------
INSERT INTO `teauser` VALUES ('1', '16111651227', '111', '曾智琴', '939129504@qq.com', '18210915622', '神龙', '软件工程', '北京城市学院', 'icon/tea_icon/timg.jpg');
INSERT INTO `teauser` VALUES ('2', '16111651128', '111', '石明翔', '939129504@qq.com', '11111111', '男', 'JAVA开发', '北京城市学院', 'icon/tea_icon/KY.png');
INSERT INTO `teauser` VALUES ('3', '16111651130', '111', '康瑶', '939129504@qq.com', '11111111', '女', '数据库开发', '北京城市学院', 'icon/tea_icon/SMX.png');
INSERT INTO `teauser` VALUES ('8', '16111659876', '111', '马云老师', null, null, null, null, null, 'icon/tea_icon/timg.jpg');
