package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bean.Result;
import util.DBUtil;

public class ResultDao {
	public int insertScore(int subjectid,int praid,int classid,int stuid,int proscore,int resscore,int total,String mysqlcode){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//							                                     start number
		
		String sql = "insert into result (pra_id,sub_id,stu_id,class_id,pro_score,res_score,score,code) values(?,?,?,?,?,?,?,?)";
		Object[] params = {praid,subjectid,stuid,classid,proscore,resscore,total,mysqlcode};
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
	
	public int updateScore(int stuid,int proscore,int resscore,int total,String mysqlcode){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//							                                     start number
		
		String sql = "update result set pro_score=?,res_score=?,score=?,code=? where stu_id=?";
		Object[] params = {proscore,resscore,total,mysqlcode,stuid};
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
	
	public Result selectScore(int stuid,int praid,int sub_id){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
//							                                     start number
		
		String sql = "select * from result  where stu_id=? and pra_id=? and sub_id=?";
		Object[] params = {stuid,praid,sub_id};
		/*S
		 * BeanListHandler:将结果集封装为list集合
		 * BeanHandler：将结果集中的第一条记录封装为对象
		 */
		try {			
			Result res = (Result)queryRunner.query(connection,sql,new BeanHandler(Result.class),params);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.release(null, null, connection);
		}
		return null;
	}
	
	public boolean isExist(int pra_id,int sub_id,int stu_id){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		
		String sql = "select count(*) from result where pra_id=? and sub_id=? and stu_id=?";
		Object[] params = {pra_id,sub_id,stu_id};
		
		try {
			
			Long res = (Long)queryRunner.query(connection,sql,new ScalarHandler(),params);
			if(res == 1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
