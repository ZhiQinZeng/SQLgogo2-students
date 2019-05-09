package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PageBean;
import bean.StuUser;
import dao.PracticeDao;
import net.sf.json.JSONObject;
import service.HomeworkService;


public class HomeworkServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//设置请求以及响应的内容类型以及编码方式
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//设置请求以及响应的内容类型以及编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = 8;
		
		HttpSession session = request.getSession();
		String username=(String)session.getAttribute("username");
		PracticeDao practiceDao = new PracticeDao();
		StuUser stuli = practiceDao.findClass(username);
		//String classname = stuli.getClassname();
		int classid = stuli.getClassId();
		//session.setAttribute("classname", classname);
		
		HomeworkService hs = new HomeworkService();
		PageBean pb = hs.findAllUserWithPage(username, pageNum, pageSize);
	
		JSONObject jsonObject = JSONObject.fromObject(pb);
		//jsonObject.put("classname", classname);
		jsonObject.put("classid",classid);
		PrintWriter pw = response.getWriter();
		pw.print(jsonObject);
		
	}
}
