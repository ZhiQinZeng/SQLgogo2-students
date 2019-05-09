package bean;

import java.util.Date;

import service.AnswerJudge;

public class tea_stu_message {
  private String tea_id;
  public String getTea_id() {
	return tea_id;
}
public void setTea_id(String tea_id) {
	this.tea_id = tea_id;
}
public String getStu_id() {
	return stu_id;
}
public void setStu_id(String stu_id) {
	this.stu_id = stu_id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getDeleted() {
	return deleted;
}
public void setDeleted(int deleted) {
	this.deleted = deleted;
}
public Date getAddtime() {
	return addtime;
}
public void setAddtime(Date addtime) {
	this.addtime = addtime;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
private String stu_id;
  private String message;
  private int deleted;
  private Date addtime;
  private String answer;
  
  
}
