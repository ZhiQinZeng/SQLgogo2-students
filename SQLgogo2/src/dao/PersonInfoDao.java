package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DBUtil;


import bean.StuUser;


public class PersonInfoDao {
	//存储图片路径
	public void uploadimage(String filename,String username) {

		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//		                                     start number
		String sql = "update teauser set profile=? where name=?";
		Object[] params = {filename,username};
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
	}
	//根据个人用户名查找出路径
	public List<StuUser> findImagePath(String username) {

		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//		                                     start number
		String sql = "select profile from stuuser where username=?";
		Object[] params = {username};
		try { 
			List<StuUser> list = (List<StuUser>)queryRunner.query(connection, sql,new BeanListHandler(StuUser.class),params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	//存储x学生个人信息
		public void saveType(StuUser stu,int id){
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			String sql = "update stuuser set e_mail=?,realname=?,sex=?  where id = ?";
			Object[] params = {stu.getE_mail(),stu.getRealname(),stu.getSex(),id};
			try { 
				queryRunner.update(connection, sql,params);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
		}
		
	//根据id查询学生信息
		public StuUser findById(int id) {

			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			String sql = "select * from stuuser where id = ?";
			Object[] params = {id};
			try { 
				StuUser stu = (StuUser)queryRunner.query(connection, sql,new BeanHandler(StuUser.class),params);
				return stu;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
}
