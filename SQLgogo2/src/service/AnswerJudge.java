package service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import util.DBUtil;

public class AnswerJudge {
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 //  static final String DB_URL = "jdbc:mysql://localhost:3306/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "970128";

	public  String judge(String dbname,String resultsql) {
		String DB_URL = "jdbc:mysql://localhost:3306/"+dbname;
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	     // System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      //System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      
	      String sql1 = "use "+dbname;
	      stmt.execute(sql1);
	      String sql = resultsql;
	      stmt.executeQuery(sql);
	      
	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
		   //se.printStackTrace();
		   StringWriter sw = new StringWriter();  
		   PrintWriter pw = new PrintWriter(sw);  
		   se.printStackTrace(pw);  
		   String msg=sw.toString();
		   String [] str = msg.split("\n");
		   String str1 = str[0].substring(0,str[0].indexOf(":"));
		      //System.out.println(str1[0]);
		   String str2 = str[0].substring(str[0].indexOf(":")+1);
		     // System.out.println(str1);
	      return str2;
		  // System.out.println(str2);
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	  // System.out.println("Goodbye!");
	   return "judgeyes";
	}//end main
*/
	public  Map<String,List<String>> judge(String dbname,String resultsql){
		QueryRunner queryRunner = new QueryRunner();
		Connection connection = DBUtil.getConnection();
		String sql1 = "use "+dbname;
		String sql2 = resultsql;
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> reli = new ArrayList<String>();
		try {
			queryRunner.update(connection, sql1);
			List<Object[]> result = (List<Object[]>)queryRunner.query(connection,sql2,new ArrayListHandler());
			for(Object[] objs:result){
				for(Object obj:objs){
					if(obj == null){
						reli.add(" ");
					}else{
						reli.add(obj.toString());
					}
				}
			}
			map.put("returnstr1", reli);
			
			return map;
			//return "judgeyes";
		} catch (SQLException se) {
			
			//se.printStackTrace();
			StringWriter sw = new StringWriter();  
		    PrintWriter pw = new PrintWriter(sw);  
		    se.printStackTrace(pw);  
		    String msg=sw.toString();
		    String [] str = msg.split("\n");
		    String str1 = str[0].substring(0,str[0].indexOf(":"));
		      //System.out.println(str1[0]);
		    String str2 = str[0].substring(str[0].indexOf(":")+1);
		     // System.out.println(str1);
		    reli.add(str2);
		    map.put("returnstr2", reli);
		    return map;
		    //return str2;
		}finally{
			DBUtil.release(null, null, connection);
		}
		
	}
}
