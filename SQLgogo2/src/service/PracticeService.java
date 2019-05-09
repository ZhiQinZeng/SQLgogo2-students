package service;

import java.util.List;

import bean.PageBean;
import bean.Subjects;
import dao.PracticeDao;

public class PracticeService {
	public PageBean findAllUserWithPage(int praid,int pageNum,int pageSize){
		
		PracticeDao practiceDao = new PracticeDao();
		List<Subjects> list = practiceDao.findSubjects(praid);
				
		int totalRecord = list.size();
		PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
		int startIndex = pb.getStartIndex();
		//有startIndex和pageSize就可以拿到每页的数据
		pb.setList(practiceDao.findOneSubjectsPage(praid,startIndex,pageSize));
		return pb;
	}
}
