package com.gamer.core.po;

import java.util.Date;

/**
 * 用户回答信息
 * @author Raindrop
 *
 */
public class Answer {
	private int id;					//id
	private int question_id;		//问题Id
	private User user;
	private int user_id;			//回答人Id
	private String answer;			//回答
	private Date date;				//回答日期
	private String dateS;			//中文日期格式
	
	
	
	public String getDateS() {
		return dateS;
	}
	public void setDateS(String dateS) {
		this.dateS = dateS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}


	
}
