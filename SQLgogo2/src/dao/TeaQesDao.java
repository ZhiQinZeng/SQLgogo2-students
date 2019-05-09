package dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import bean.teaQuestion;
import util.DBUtil;

public class TeaQesDao {



	public List<teaQuestion> findQes(String teaName) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from teaquestions where teaName = ? and deleted = 1";
		Object[] params = {teaName};
		
		try {
			List<teaQuestion> list = (List<teaQuestion>)queryRunner.query(connection, sql,new BeanListHandler(teaQuestion.class),params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public teaQuestion findOne(String id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from teaquestions where teaQuestionId = ? and deleted = 1";
		Object[] params = {id};
		
		try {
			teaQuestion one = (teaQuestion)queryRunner.query(connection, sql,new BeanHandler(teaQuestion.class),params);
			return one;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public List<teaQuestion> allQuestion() {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from teaquestions where deleted = 1";
		
		
		try {
			List<teaQuestion> list = (List<teaQuestion>)queryRunner.query(connection, sql,new BeanListHandler(teaQuestion.class));
	
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}

	
}
