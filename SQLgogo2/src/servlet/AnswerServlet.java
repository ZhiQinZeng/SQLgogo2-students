package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Result;
import bean.StuUser;
import bean.Subjects;
import dao.PracticeDao;
import dao.ResultDao;
import dao.SubjectDao;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.AnswerJudge;

public class AnswerServlet extends HttpServlet {
	String subid;  //题目的ID
	String method;
	
	int proscore ;
	int resscore;
	int total ;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//客户端是以UTF-8编码提交的，那么服务器端request对象就以UTF-8编码接收(request.setCharacterEncoding(“UTF-8”))
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//设置请求以及响应的内容类型以及编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		/*String question = request.getParameter("question");
		System.out.println("question是"+question);
		*/
		HttpSession session = request.getSession();
		method = request.getParameter("method");
		subid = request.getParameter("subjectid"); //答题
		
		if("gettable".equals(method)){   //ajax进行加载库和表
			String subjectid = (String)request.getParameter("subjectid");
			int subid = Integer.parseInt(subjectid);
			int praid = Integer.parseInt((String)request.getParameter("mypraid"));
			
			String username = (String)session.getAttribute("username");
			UserDao userDao = new UserDao();
			StuUser stuUser = userDao.SelectByName(username);
			int stuid = stuUser.getId();
			
			ResultDao resDao = new ResultDao();
			Result res = resDao.selectScore(stuid, praid, subid);
			
			String dbname = (String)request.getParameter("dbname");
			
			PracticeDao practiceDao = new PracticeDao();
			List<Subjects> list = practiceDao.findSubject_detail(subid);  
			String subname = list.get(0).getSubject_detail();
			
			PracticeDao pradao = new PracticeDao();
			Subjects subject = pradao.findSubject(subid);
			
			SubjectDao subjectDao = new SubjectDao();			
			List<String> tabli = subjectDao.findTables(dbname);
			
			JSONArray jsonArray = JSONArray.fromObject(tabli);
			jsonArray.add(subname);
			jsonArray.add(res);
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);
		}else if(("code").equals(method)){   //判分
			 //先进行判断学生的代码是否合法
			 String filepath = this.getServletContext().getRealPath("/WEB-INF/words.txt");	
			 String mysqlcode = request.getParameter("mysqlcode");
			 List<String> undos = readwords(filepath);
			 String[] codes = mysqlcode.split(" ");
			 List<String> stuundos = new ArrayList<String>();
			 for(String str:codes){
				 stuundos.add(str);
			 }
			 int undocount = KeyCount(undos, stuundos);
			 if(undocount>0){   //学生操作不合法
				 
				 PrintWriter pw = response.getWriter();
				 pw.print("errorsql");
				 
			 }else{    //语句合法则进行下一步判断
		 
		 
				 String username = (String)session.getAttribute("username");
				 UserDao userDao = new UserDao();
				 StuUser stuUser = userDao.SelectByName(username);
				 int stuid = stuUser.getId();
				 
				 String dbname = request.getParameter("dbname");
				 String classid1 = (String)request.getParameter("myclassid");
				 int classid = Integer.parseInt(classid1);
				 String praid1 = (String)request.getParameter("mypraid");
				 int praid = Integer.parseInt(praid1);
				 String subjectid1 = (String)(request.getParameter("subjectid"));
				 int subjectid = Integer.parseInt(subjectid1);
				 
				 ResultDao resDao = new ResultDao();
				 //答案sql
				 PracticeDao pradao = new PracticeDao();
				 Subjects subject = pradao.findSubject(subjectid);
				 String answersql = subject.subject_answer;
				 
				 AnswerJudge anju = new AnswerJudge();
				 // String judgeResult = anju.judge(dbname, mysqlcode);
				  String judgeResult;
				  
				  //学生sql答案
				  Map<String,List<String>> stumap = anju.judge(dbname, mysqlcode);
				  //老师标准sql答案
				  Map<String,List<String>> teamap = anju.judge(dbname, answersql);
				  
				  if(stumap.get("returnstr2") != null){  //代码有异常，结果0分，筛选过程关键词给过程分
					  judgeResult = stumap.get("returnstr2").get(0);
					  
					//关键词个数
					 String choice_key = subject.key_choice;
					 String[] answerkeys = choice_key.split(",");
					 String[] stukeys = mysqlcode.split(" ");
					 List answerlist = Arrays.asList(answerkeys);
					 List stulist = Arrays.asList(stukeys);
					 int num = KeyCount(answerlist,stulist);//学生关键词个数
					 
					 //关键词过程分
					 proscore = subject.setpro_score / answerkeys.length * num;
					 resscore = 0;
					 total = proscore+resscore;
					 if(!resDao.isExist(praid, subjectid, stuid)){  //如果不存在则插入
						 int res = resDao.insertScore(subjectid,praid,classid,stuid,proscore, resscore, total,mysqlcode);
					 }else{  //存在则更新分数
						 int res = resDao.updateScore(stuid,proscore, resscore, total,mysqlcode);
					 }
				  }else{  //代码没有异常，结果比对；结果有一点不一样，结果分0分，无错结果分满分
					  
					  List<String> stures1 = stumap.get("returnstr1");
					  List<String> teares1 = teamap.get("returnstr1");
					  String stures = stures1.toString();
					  String teares = teares1.toString();
					  if(stures.equals(teares)){  //结果正确则过程分和结果分都直接满分
						  proscore = subject.setpro_score;
						  resscore = subject.setres_score;
						  total = subject.set_score;
						  judgeResult = "Congratulations!The sql compile successfully and the result is right!";
					  }else{  //结果不正确则结果分为0，过程分关键词比对
						//关键词个数
						 String choice_key = subject.key_choice;
						 String[] answerkeys = choice_key.split(",");
						 String[] stukeys = mysqlcode.split(" ");
						 List answerlist = Arrays.asList(answerkeys);
						 List stulist = Arrays.asList(stukeys);
						 int num = KeyCount(answerlist,stulist);//学生关键词个数
						 //关键词过程分
						 proscore = subject.setpro_score / answerkeys.length * num;
						 resscore = 0;
						 total = proscore+resscore;
						 judgeResult = "Sad!The sql compile successfully but the result is error!";
						
					  }
					 
					  if(!resDao.isExist(praid, subjectid, stuid)){  //如果不存在则插入
						 int res = resDao.insertScore(subjectid,praid,classid,stuid,proscore, resscore, total,mysqlcode);
						 //System.out.println("来了吗老铁"+res);
					  }else{  //存在则更新分数
						 int res = resDao.updateScore(stuid,proscore, resscore, total,mysqlcode);
						 //System.out.println("来了吗老铁2"+res);
					  }
					 
				  }
				  
				  JSONObject jsonObject = new JSONObject();
				  jsonObject.put("result", judgeResult);
				  jsonObject.put("proscore", proscore);
				  jsonObject.put("resscore", resscore);
				  jsonObject.put("total", total);
				  PrintWriter pw = response.getWriter();
				  pw.print(jsonObject);
				}
		}
	}
	
	public int KeyCount(List answerlist,List stulist){
		int num = 0;
		for(Object al:answerlist){
			if(stulist.contains(al)){
				num += 1;
			}
		}
		return num;
	}
	
	//读取words文件里面的非法关键字
	public List<String> readwords(String filename) throws IOException{
		FileInputStream fis = new FileInputStream(filename);
		byte[] buff = new byte[1024]; 
		int hasread = 0;
		StringBuffer res = new StringBuffer();
		while((hasread=fis.read(buff))>0){
			//System.out.println(new String(buff,0,hasread));
			res.append(new String(buff,0,hasread));
		}
		List<String> list = new ArrayList<String>();
		String[] str = res.toString().split("\r\n");
		for(String st:str){
			list.add(st);
			//System.out.println(st);
		}
		
		return list;
	}
	
}
