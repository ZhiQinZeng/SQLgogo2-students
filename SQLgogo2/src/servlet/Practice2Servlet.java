package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Practice2Servlet extends HttpServlet {
	String praid;
	String downloadid;
	String dbname;
	String subjectid;
	String classname;
	
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
		
		 praid = request.getParameter("praid");
		 downloadid = request.getParameter("downloadid");
		 dbname = request.getParameter("dbname");
		 subjectid = request.getParameter("subjectid");
		 classname = request.getParameter("classname");
		 
		if(!(praid==null)){
			work(request,response);
		}else if(!(downloadid==null)){
			download(request,response);
		}else if(!(subjectid==null)){
			answer(request,response);
		}
		
		
	}
	
	public void work(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*HttpSession session = request.getSession();
		session.setAttribute("dbname", dbname);   //存储dbname
		session.setAttribute("praid", praid);*/
		request.setAttribute("dbname", dbname);
		request.setAttribute("praid", praid);
		request.setAttribute("classname", classname);
		request.getRequestDispatcher("student/workshow.jsp").forward(request, response);
		/*response.sendRedirect("/SQLgogo2/student/workshow.jsp");*/
	
	}
	
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.setAttribute("upid", upid);
		/*HttpSession session=request.getSession();
		session.setAttribute("upid", upid);
		response.sendRedirect("/SQLgogo/teacher/updateClass.jsp");*/
	}
	
	public void answer(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//request.setAttribute("upid", upid);
		
		/*HttpSession session=request.getSession();
		session.setAttribute("subjectid", subjectid);
		response.sendRedirect("/SQLgogo2/student/answer.jsp");*/
	}

	

}
