package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import bean.StuUser;
import bean.tea_stu_message;
import dao.UserDao;


public class UserServlet extends HttpServlet {
	UserDao userDao=null;
	public void init() throws ServletException {
		userDao=new UserDao();
		super.init();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//设置请求以及响应的内容类型以及编码方式
		resp.setContentType("text/html;charset=UTF-8");
		
		
		String action = req.getServletPath();
		try {
			
			if (action.equals("/Login")) {
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				
				 StuUser stuuser=userDao.findUser(username, password);
				
				 
				if (stuuser!=null && (username).equals(stuuser.getUsername()) && (password).equals(stuuser.getPassword())) {
					// 成功
					String realname=stuuser.getRealname();	
					
					HttpSession session=req.getSession();
					session.setMaxInactiveInterval(24*3600);//以秒为单位
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					session.setAttribute("realname",realname);
					session.setAttribute("id",stuuser.getId());
					JSONObject obj = new JSONObject();
					obj.put("user", stuuser);
					resp.getWriter().print(obj);
					
				//	resp.sendRedirect("/SQLgogo2/student/main.jsp");        //重新定向url
				} else {
					resp.getWriter().print("error");
				}
			 }else if(action.equals("/pwd_modify")){
				 HttpSession session=req.getSession();
				 String pwd_old =  (String) session.getAttribute("password");
				 int id =  (int) session.getAttribute("id");
				 
				 String password_old = req.getParameter("password_old");
				 String password_new = req.getParameter("password_new");
				 
				 if(!password_old.equals(pwd_old)){
					 resp.getWriter().print("old_none");
					 return;
				 }else{
					 session.setAttribute("password", password_new);
					 userDao.updatePwd(id, password_new);
					 resp.getWriter().print("modify_success");
				 }
			 }else if(action.equals("/stu_tea_message")){  //暂时先写成这样，教师id和学生id关系还没理清楚，还有没做一天时间限制提交
				 tea_stu_message message = new tea_stu_message();
				 
				 String stu_tea_message = req.getParameter("stu_tea_message");
				 HttpSession session=req.getSession();
				
				 String id =  (int) session.getAttribute("id")+"";
				 
				 message.setMessage(stu_tea_message);
				 message.setStu_id(id);
				 
				 userDao.add_stu_tea_message(message);
				 
				 resp.getWriter().print("message_success");
			 }
		}catch (Exception e) {
			e.printStackTrace(System.out);
			resp.getWriter().print("<script>alert('内部错误')</script>");
			resp.getWriter().print("<script>history.back()</script>");
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
			try {
				doPost(req,resp);
			} catch (ServletException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	
}
