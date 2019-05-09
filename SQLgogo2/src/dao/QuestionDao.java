package dao;

import java.sql.Connection;




import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Practice;
import bean.Question;
import servlet.QesServlet;
import util.DBUtil;

public class QuestionDao {


	public Question findQes(String studentName) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from questions where studentName = ? and deleted = 1";
		Object[] params = {studentName};
		
		try {
			Question qes = (Question)queryRunner.query(connection, sql,new BeanHandler(Question.class),params);
			return qes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	public Question findQesByid(String id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from questions where QuestionId = ? and deleted = 1";
		Object[] params = {id};
		
		try {
			Question qes = (Question)queryRunner.query(connection, sql,new BeanHandler(Question.class),params);
			return qes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	public List<Question> findStuQes(String id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from questions where studentsNumber = ? and deleted = 1";
		Object[] params = {id};
		
		try {
			List<Question> qes = (List<Question>)queryRunner.query(connection, sql,new BeanListHandler(Question.class),params);
			return qes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	public List<Question> allQuestion() {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "select * from questions where deleted = 1";

		try {
			List<Question> list = (List<Question>)queryRunner.query(connection, sql,new BeanListHandler(Question.class));
	
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public void update(String name,String qesDeal) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();

		
		String sql = "update questions set questionDeal = ? where studentName = ?";
		Object[] params = {qesDeal,name};
		
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		
	}


	
	public void delete(String qes_id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		
		String sql = "update subjects set deleted = 0 where QuestionId = ?";
		Object[] params = {qes_id};           
		

		try { 
			queryRunner.update(connection, sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
	}
	
	public void star(String star,String id) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql = "update questions set star = ? where QuestionId = ?";
		Object[] params = {star,id};
		
		try { 
			queryRunner.update(connection, sql,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}	
	}

	public void add(Question question) {
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();

		String sql = "insert into questions (className,studentName,studentsNumber,addtime,questionProtray,title,filepath) values(?,?,?,?,?,?,?)";
		Object[] params = {question.getClassName(),question.getStudentName(),question.getStudentsNumber(),new Timestamp(question.getAddtime().getTime()),question.getQuestionProtray(),question.getTitle(),question.getFilepath()};//,practice.getPublishDay(),practice.getDeadline()
	     
		try { 
			queryRunner.update(connection,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
	}
	
}
