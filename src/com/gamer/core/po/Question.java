package com.gamer.core.po;

import java.util.Date;

/**
 * 问答精灵——问题信息
 * @author Raindrop
 *
 */
public class Question {
	private int id;				//Id
	private int user_id;		//提问者Id
	private String question;	//问题
	private String content;		//提问内容
	private Date date;			//提问日期
	private User user;			//提问用户对象
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", user_id=" + user_id + ", question=" + question + ", content=" + content
				+ ", date=" + date + ", user=" + user + "]";
	}
	
}
