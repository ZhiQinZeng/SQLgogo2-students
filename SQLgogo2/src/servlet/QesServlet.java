package servlet;

import java.io.IOException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import bean.Question;
import bean.StuUser;
import bean.teaQuestion;
import dao.QuestionDao;
import dao.TeaDao;
import dao.TeaQesDao;
import dao.UserDao;

/**
 * Servlet implementation class QesServlet
 */
@WebServlet("/QesServlet")
public class QesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userDao = new UserDao();
       QuestionDao questionDao = new QuestionDao();
       TeaQesDao teaDao = new TeaQesDao();
       TeaDao  teauserDao = new TeaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public static int compare_date(String DATE1, String DATE2) {       
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//设置请求以及响应的内容类型以及编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		
		String status = request.getParameter("status");
		
		if("propose".equals(status)){
			

			String title = request.getParameter("title");
			String protray = request.getParameter("protray");
			String stu_id  = request.getParameter("user_id");
			
			//判断是否一天多次提交
			Date last_pro_date = userDao.SelectById(stu_id).getLast_pro_date();
			System.out.println("last_pro_date::::::::::::::"+last_pro_date);
			if(last_pro_date==null){  //如果没有提交过 时间为空
				StuUser stuUser = userDao.SelectById(stu_id); 
				Date d = new Date();
				Question qes = new Question();
				
				qes.setClassName(stuUser.getClassname());
				qes.setQuestionProtray(protray);
				qes.setTitle(title);
				qes.setStudentsNumber(stuUser.getId());
				qes.setStudentName(stuUser.getRealname());
				String relativePath = "../../SQLgogo2/student/"+stuUser.getProfile();
				qes.setFilepath(relativePath);
				
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		         
				try {
					qes.setAddtime(sf.parse( df.format(d)));
					stuUser.setLast_pro_date(sf.parse( df.format(d)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				questionDao.add(qes);
				userDao.update_last_pro_date(stuUser,stu_id);
				response.getWriter().write("done");
				response.getWriter().close();
			}else{   //如果提交过，做判断是否可以提交
				 
				 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 Date d = new Date();
				// 
				 String standard_time = df.format(new Date(last_pro_date.getTime() + 24 * 60 * 60 * 1000)); //设置限制时间
				 System.out.println("提交一天后的对比日期：" + standard_time);
				 int flag = compare_date(standard_time,df.format(d).toString());
				 System.out.println("flag:::::::::::::::"+flag);
				    
				 if(flag!=1){  //超过一天，可以提交了
					   StuUser stuUser = userDao.SelectById(stu_id); 
						Date d2 = new Date();
						Question qes = new Question();
						
						qes.setClassName(stuUser.getClassname());
						qes.setQuestionProtray(protray);
						qes.setTitle(title);
						qes.setStudentsNumber(stuUser.getId());
						qes.setStudentName(stuUser.getRealname());
						String relativePath = "../../SQLgogo2/student/"+stuUser.getProfile();
						qes.setFilepath(relativePath);
						
						 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						 DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				         
						try {
							qes.setAddtime(sf.parse( df2.format(d2)));
							stuUser.setLast_pro_date(sf.parse( df2.format(d2)));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						questionDao.add(qes);
						userDao.update_last_pro_date(stuUser,stu_id);
						response.getWriter().write("done");
						response.getWriter().close();
				 }else{
					 response.getWriter().write("date_decline");
					response.getWriter().close();
				 }
			}
		
		}else if("tea_qes".equals(status)){ 	
				List<teaQuestion> list = teaDao.allQuestion();
				 for(int  i=0;i<list.size();i++){
					String photo =  teauserDao.SelectById( list.get(i).getTeaNumber() ).getProfile();
					list.get(i).setPhoto("../../SQLgogo/teacher/"+photo);
				   }   
				
				JSONArray json = new JSONArray(list);
				response.getWriter().write(json.toString());
				response.getWriter().close();				
		}else if("stu_qes".equals(status)){ 	
			String id = request.getParameter("id");
			List<Question> list = questionDao.findStuQes(id);
			 for(int  i=0;i<list.size();i++){
				String filepath =  userDao.SelectById( list.get(i).getStudentsNumber()+"" ).getProfile();
				list.get(i).setFilepath(filepath);
			   }   
			
			JSONArray json = new JSONArray(list);
			response.getWriter().write(json.toString());
			response.getWriter().close();				
	}else if("tea_qes_detail".equals(status)){
			String id = request.getParameter("id");
			teaQuestion tea_qes = teaDao.findOne(id);

			String photo =  teauserDao.SelectById( tea_qes.getTeaNumber() ).getProfile();
			tea_qes.setPhoto("../../SQLgogo/teacher/"+photo);
           
			JSONObject obj = new JSONObject();
			obj.put("tea_qes", tea_qes);
			response.getWriter().print(obj);
		}else if("stu_qes_detail".equals(status)){
			String id = request.getParameter("id");
			Question stu_qes = questionDao.findQesByid(id);

			String filepath =  userDao.SelectById( stu_qes.getStudentsNumber()+"" ).getProfile();
			stu_qes.setFilepath(filepath);

			JSONObject obj = new JSONObject();
			obj.put("stu_qes", stu_qes);
			response.getWriter().print(obj);
		}
		
		
	}

}
