package service;

import java.util.List;

import bean.PageBean;
import bean.Practice;
import bean.StuUser;
import dao.PracticeDao;

public class HomeworkService {
	public PageBean findAllUserWithPage(String username,int pageNum,int pageSize){
		
		PracticeDao practiceDao = new PracticeDao();
		StuUser stuli = practiceDao.findClass(username);
		//String classname = stuli.getClassname();	
		int classid = stuli.getClassId();
		List<Practice> list=practiceDao.findPractice(classid);
		
		int totalRecord = list.size();
		PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
		int startIndex = pb.getStartIndex();
		//有startIndex和pageSize就可以拿到每页的数据
		pb.setList(practiceDao.findOnePage(classid,startIndex,pageSize));
		return pb;
	}
}
