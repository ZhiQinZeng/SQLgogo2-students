package bean;

public class Practice {
	public int PracticeId;
	public String PracticeName;
	public String dbname;
	public String ClassName;
	public String PracticeGenre;
	public String PublishDay;
	public String Deadline;
	public int getPracticeId() {
		return PracticeId;
	}
	public void setPracticeId(int practiceId) {
		PracticeId = practiceId;
	}
	public String getPracticeName() {
		return PracticeName;
	}
	public void setPracticeName(String practiceName) {
		PracticeName = practiceName;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getPracticeGenre() {
		return PracticeGenre;
	}
	public void setPracticeGenre(String practiceGenre) {
		PracticeGenre = practiceGenre;
	}
	public String getPublishDay() {
		return PublishDay;
	}
	public void setPublishDay(String publishDay) {
		PublishDay = publishDay;
	}
	public String getDeadline() {
		return Deadline;
	}
	public void setDeadline(String deadline) {
		Deadline = deadline;
	}
	
	
}
