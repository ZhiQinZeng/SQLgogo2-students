package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.TeaUser;
import util.DBUtil;

public class TeaDao {

		public TeaUser SelectById(int i) {
			QueryRunner queryRunner = new QueryRunner();
			Connection connection = DBUtil.getConnection();
			String sql = "select * from teauser where id = ? ";
			Object[] params = {i};
			/*
			 * BeanListHandler:将结果集封装为list集合
			 * BeanHandler：将结果集中的第一条记录封装为对象
			 */
			try {
				TeaUser user = (TeaUser)queryRunner.query(connection, sql,new BeanHandler(TeaUser.class),params);
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBUtil.release(null, null, connection);
			}
			return null;
		}
		

}
