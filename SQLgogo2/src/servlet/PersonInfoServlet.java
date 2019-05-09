package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import bean.StuUser;

import dao.PersonInfoDao;



public class PersonInfoServlet extends HttpServlet {
	 PersonInfoDao perdao = new PersonInfoDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//设置请求以及响应的内容类型以及编码方式
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				String status = request.getParameter("status");
				
				if("change".equals(status)){
					String e_mail = request.getParameter("email");
					String sex = request.getParameter("sex");
					String name = request.getParameter("name");
					
					HttpSession session=request.getSession(); 
				    int id = (int)session.getAttribute("id");

					session.setAttribute("realname",name);
					
				    StuUser stu = new StuUser();
				    stu.setSex(sex);
				    stu.setRealname(name);
				    stu.setE_mail(e_mail);
				   
				    perdao.saveType(stu,id);
				    
					response.getWriter().write("ok");
					response.getWriter().close();
				}else if("check".equals(status)){			
					
					HttpSession session=request.getSession(); 
					try{
						    int id = (int)session.getAttribute("id");
						    StuUser stu = perdao.findById(id);
							JSONObject jsonObject=new JSONObject();
							jsonObject.put("user", stu);
							out.println(jsonObject.toString());
					}catch (Exception e) {
						out.println("null");
						// TODO: handle exception
					}
	
				}
			
			    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
