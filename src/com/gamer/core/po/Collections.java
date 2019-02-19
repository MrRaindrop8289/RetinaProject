package com.gamer.core.po;

import java.util.Date;

/**
 * 用户收藏图片信息
 * @author Raindrop
 *
 */
public class Collections {
	private int id;				//Id
	private int user_id;		//用户Id
	private int picture_id;		//图片Id
	private Date date;			//收藏日期
	private String dateS;		//中文日期格式
	
	
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}
	@Override
	public String toString() {
		return "Collections [id=" + id + ", user_id=" + user_id + ", picture_id=" + picture_id + ", date=" + date
				+ ", dateS=" + dateS + "]";
	}

	
}
