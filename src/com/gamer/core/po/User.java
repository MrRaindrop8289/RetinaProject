package com.gamer.core.po;

import java.util.Date;

/**
 * 用户信息
 * @author Raindrop
 *
 */
public class User {
	private int id;					//Id
	private String account;			//账号_邮箱
	private String password;		//密码
	private String name;			//昵称
	private String sex;				//性别		0——man	1——women
	private String head_src;		//头像位置
	private int question;			//密保问题
	private String answer;			//密保问题回答
	private String signature;		//个性签名
	private int grade;				//级别	0——图片录入员	1——资深医生	2——普通医生	3——学生 
	private boolean permission;		//权限	true——管理员		false——用户
	private Date date;				//注册日期
	private String dateS;			//中文日期格式
	
	public String getDateS() {
		return dateS;
	}
	public void setDateS(String dateS) {
		this.dateS = dateS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHead_src() {
		return head_src;
	}
	public void setHead_src(String head_src) {
		this.head_src = head_src;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public boolean isPermission() {
		return permission;
	}
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
