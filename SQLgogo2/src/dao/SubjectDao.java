package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bean.Practice;
import util.DBUtil;
import util.DBUtils;

public class SubjectDao {
	//找到老师建立的所有的库
	public List<String> findDatabase(){
		
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//		                                     start number
		
		 String sql = "select distinct dbname from practice ";
		//Object[] params = {username};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			
			List<String> list = (List<String>)queryRunner.query(connection, sql,new ColumnListHandler());
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	//找到对应库下面所有表
		public List<String> findTables(String dbname){
			
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			
			 String sql = "select table_name from information_schema.tables "+
					 "where table_schema=?"+
					 " and table_type='base table'; ";
			Object[] params = {dbname};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				
				List<String> list = (List<String>)queryRunner.query(connection, sql,new ColumnListHandler(),params);
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
		//找到对应表中所有数据
		public List<Object[]> findDatas(String dbname,String tabname) throws ClassNotFoundException, SQLException{
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtils.getConnection(dbname);
//					                                     start number
			
			 String sql = "select * from "+tabname;
			//Object[] params = {dbname};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				//方法返回值 每行是一个对象数组，存储到List
				List<Object[]> list = (List<Object[]>)queryRunner.query(connection, sql,new ArrayListHandler());
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
		
				
	//找到对应表中所有字段类型字段和字段注释
	public List<Object[]> findTypes(String dbname,String tabname) throws ClassNotFoundException, SQLException{
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtils.getConnection(dbname);
//					                                     start number
		
		 String sql = "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.COLUMNS where table_name = ? and table_schema = ?";
		Object[] params = {tabname,dbname};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			//方法返回值 每行是一个对象数组，存储到List
			List<Object[]> list = (List<Object[]>)queryRunner.query(connection, sql,new ArrayListHandler(),params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	
				
}