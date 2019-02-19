package com.gamer.core.po;

import java.util.Date;

/**
 * 图片信息
 * @author Raindrop
 *
 */
public class Picture {
	private int id;					//Id
	private String src_image;		//图片存储位置
	private int doctor1;			//医生1
	private int point1_x;			//医生1标注位置
	private int point1_y;
	private int doctor2;			//医生2
	private int point2_x;			//医生2标注位置
	private int point2_y;
	private int doctor3;			//医生3
	private int point3_x;			//医生3标注位置
	private int point3_y;
	private boolean same;			//标注位置是否相同
	private int doctor_pro;			//资深医生
	private int point_x;			//资深医生标注位置
	private int point_y;
	private int times;				//标注次数
	private Date date;				//日期时间
	private String dateS;			//中文日期格式
	private String isCollection; 	//是否被收藏了
	
	public String getDateS() {
		return dateS;
	}
	public void setDateS(String dateS) {
		this.dateS = dateS;
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
	public String getSrc_image() {
		return src_image;
	}
	public void setSrc_image(String src_image) {
		this.src_image = src_image;
	}
	public int getDoctor1() {
		return doctor1;
	}
	public void setDoctor1(int doctor1) {
		this.doctor1 = doctor1;
	}
	public int getPoint1_x() {
		return point1_x;
	}
	public void setPoint1_x(int point1_x) {
		this.point1_x = point1_x;
	}
	public int getPoint1_y() {
		return point1_y;
	}
	public void setPoint1_y(int point1_y) {
		this.point1_y = point1_y;
	}
	public int getDoctor2() {
		return doctor2;
	}
	public void setDoctor2(int doctor2) {
		this.doctor2 = doctor2;
	}
	public int getPoint2_x() {
		return point2_x;
	}
	public void setPoint2_x(int point2_x) {
		this.point2_x = point2_x;
	}
	public int getPoint2_y() {
		return point2_y;
	}
	public void setPoint2_y(int point2_y) {
		this.point2_y = point2_y;
	}
	public int getDoctor3() {
		return doctor3;
	}
	public void setDoctor3(int doctor3) {
		this.doctor3 = doctor3;
	}
	public int getPoint3_x() {
		return point3_x;
	}
	public void setPoint3_x(int point3_x) {
		this.point3_x = point3_x;
	}
	public int getPoint3_y() {
		return point3_y;
	}
	public void setPoint3_y(int point3_y) {
		this.point3_y = point3_y;
	}
	public boolean isSame() {
		return same;
	}
	public void setSame(boolean same) {
		this.same = same;
	}
	public int getDoctor_pro() {
		return doctor_pro;
	}
	public void setDoctor_pro(int doctor_pro) {
		this.doctor_pro = doctor_pro;
	}
	public int getPoint_x() {
		return point_x;
	}
	public void setPoint_x(int point_x) {
		this.point_x = point_x;
	}
	public int getPoint_y() {
		return point_y;
	}
	public void setPoint_y(int point_y) {
		this.point_y = point_y;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getIsCollection() {
		return isCollection;
	}
	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}
	
}
