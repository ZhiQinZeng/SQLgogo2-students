package bean;

import java.util.Date;

public class StuUser {
	private int id;
	private String username;
	private String password;
	private String realname;
	private String classname;
	private String e_mail;
	private String phone_num;
	private String sex;
	private String major;
	private String company;
	private String profile;
	private Date last_pro_date;
	public Date getLast_pro_date() {
		return last_pro_date;
	}

	public void setLast_pro_date( Date date) {
		this.last_pro_date =  date;
	}

	private int ClassId;
	
	public StuUser(int id, String username, String password, String realname, String classname, String e_mail,
			String phone_num, String sex, String major, String company, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.classname = classname;
		this.e_mail = e_mail;
		this.phone_num = phone_num;
		this.sex = sex;
		this.major = major;
		this.company = company;
		this.profile = profile;
	}
	
	public StuUser() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getClassId() {
		return ClassId;
	}

	public void setClassId(int classId) {
		ClassId = classId;
	}
	
	
	
	
}
