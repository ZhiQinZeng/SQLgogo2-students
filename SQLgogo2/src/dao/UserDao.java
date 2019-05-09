package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.Question;
import bean.StuUser;
import bean.tea_stu_message;
import util.DBUtil;

public class UserDao {
//根据用户名和密码查询用户信息
	public StuUser findUser(String username,String password) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from stuuser where username = ? and password = ?";
		Object[] params = {username,password};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			StuUser user = (StuUser)queryRunner.query(connection, sql,new BeanHandler(StuUser.class),params);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public void update(StuUser StuUser) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		//start number
		String sql = "update stuuser set username = ?,password = ?,realname = ?,classname = ?,e_mail = ?,phone_num=?,sex=?,major=?,company=?";
		Object[] params = {StuUser.getUsername(),StuUser.getPassword(),StuUser.getRealname(),StuUser.getClassname(),StuUser.getE_mail(),StuUser.getPhone_num(),StuUser.getSex(),StuUser.getMajor(),StuUser.getCompany()};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		
	}
	public void update_last_pro_date(StuUser StuUser,String id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		//start number
		String sql = "update stuuser set last_pro_date = ? where id=?";
		Object[] params = {new Timestamp(StuUser.getLast_pro_date().getTime()),id};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		
	}
	public StuUser SelectByName(String username) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from stuuser where username = ? ";
		Object[] params = {username};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			StuUser user = (StuUser)queryRunner.query(connection, sql,new BeanHandler(StuUser.class),params);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public StuUser SelectById(String i) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from stuuser where id = ? ";
		Object[] params = {i};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			StuUser user = (StuUser)queryRunner.query(connection, sql,new BeanHandler(StuUser.class),params);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	public void updateProfile(int id,String profile) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		//start number
		String sql = "update stuuser set profile = ? where id=?";
		Object[] params = {profile,id};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		
	}
	
	public void updatePwd(int id,String new_pwd) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		//start number
		String sql = "update stuuser set password = ? where id=?";
		Object[] params = {new_pwd,id};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 * ScalarHandler: 处理单个值，比如记录的个数
		 */
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		
	}
	
	public void add_stu_tea_message(tea_stu_message message) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();

		String sql = "insert into tea_stu_message (stu_id,message) values(?,?)";
		Object[] params = {message.getStu_id(),message.getMessage()};//,practice.getPublishDay(),practice.getDeadline()
	     
		try { 
			queryRunner.update(connection,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
	}
}
