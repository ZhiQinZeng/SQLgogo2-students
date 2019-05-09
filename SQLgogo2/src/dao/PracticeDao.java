package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.Practice;
import bean.StuUser;
import bean.Subjects;
import util.DBUtil;

public class PracticeDao {
	//按照用户名查找用户所在班级
	public StuUser findClass(String username){
		
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//		                                     start number
		
		 String sql = "select classid from stuuser where username=?";
		Object[] params = {username};
		/*
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			
			StuUser list = (StuUser)queryRunner.query(connection, sql,new BeanHandler(StuUser.class),params);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	           
	            
	
	
	//按照班级查找所有的练习信息
		public List<Practice> findPractice(int classid){
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			
			String sql = "select PracticeId,PracticeName,dbname,PublishDay,Deadline from practice where classid=?";
			Object[] params = {classid};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				
				List<Practice> list = (List<Practice>)queryRunner.query(connection, sql,new BeanListHandler(Practice.class),params);
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
		
		
	//按照班级和发布的练习查找所有的练习里面的题目
	public List<Subjects> findSubjects(int praid){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//					                                     start number
		
		//String sql = "select SubjectId,SubjectName,Scores,ExamScores,Total from subjects join practice on subjects.PracticeId=practice.PracticeId where ClassName=? and subjects.PracticeId=?";
		String sql = "select SubjectId,SubjectName,Scores,ExamScores,Total from subjects where SubjectId in (select sub_id from pra_sub where pra_id = ?)";
		Object[] params = {praid};
		/*S
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {			
			List<Subjects> list = (List<Subjects>)queryRunner.query(connection, sql,new BeanListHandler(Subjects.class),params);
			//System.out.println("list是"+list);
			//System.out.println("classname是"+classname);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
		
		//根据练习题的ID查找练习题目
		public List<Subjects> findSubject_detail(int subjectid){
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//					                                     start number
			
			String sql = "select subject_detail from subjects  where SubjectId=?";
			Object[] params = {subjectid};
			/*S
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				
				List<Subjects> list = (List<Subjects>)queryRunner.query(connection, sql,new BeanListHandler(Subjects.class),params);
				//System.out.println("list是"+list);
				//System.out.println("classname是"+classname);
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}

				
//		查询数据的总条数
		public int getCount(String classname) {
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			String sql = "select count(PracticeId) from Practice where ClassName=?";
			Object[] params = {classname};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 * ScalarHandler: 处理单个值，比如记录的个数
			 */
			try { 
				long count = (long)queryRunner.query(connection, sql,new ScalarHandler(),params);
				return (int) count;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return 0;
		}




		public List<Practice> findOnePage(int classid, int startIndex, int pageSize) {
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			
			String sql = "select PracticeId,PracticeName,dbname,PublishDay,Deadline from practice where classid=? limit ?,?";

			Object[] params = {classid,startIndex,pageSize};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				
				List<Practice> list = (List<Practice>)queryRunner.query(connection, sql,new BeanListHandler(Practice.class),params);
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}




		public List<Subjects> findOneSubjectsPage( int praid, int startIndex, int pageSize) {
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
//			                                     start number
			
			//String sql = "select SubjectId,SubjectName,Scores,ExamScores,Total from subjects join practice on subjects.PracticeId=practice.PracticeId where ClassName=? and subjects.PracticeId=? limit ?,?";
			String sql = "select * from subjects where SubjectId in (select sub_id from pra_sub where pra_id = ?) limit ?,?";

			Object[] params = {praid,startIndex,pageSize};
			/*S
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				
				List<Subjects> list = (List<Subjects>)queryRunner.query(connection, sql,new BeanListHandler(Subjects.class),params);
				
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
		
		//根据练习题的ID查找练习答案
	public Subjects findSubject(int subjectid){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//							                                     start number
		
		String sql = "select * from subjects  where SubjectId=?";
		Object[] params = {subjectid};
		/*S
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			
			Subjects list = (Subjects)queryRunner.query(connection, sql,new BeanHandler(Subjects.class),params);
			//System.out.println("list是"+list);
			//System.out.println("classname是"+classname);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public int updateScore(int proscore,int resscore,int total,int subjectid){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//							                                     start number
		
		String sql = "update subjects set ExamScores=?,Scores=? ,Total=? where SubjectId = ?";
		Object[] params = {proscore,resscore,total,subjectid};
		/*S
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {
			
			int res = queryRunner.update(connection,sql,params);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return 0;
	}
		
}
