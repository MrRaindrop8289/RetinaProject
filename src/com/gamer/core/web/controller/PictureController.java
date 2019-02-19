package com.gamer.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gamer.common.utils.*;
import com.gamer.core.po.*;
import com.gamer.core.service.*;

@Controller
public class PictureController {
	//文件夹位置
	private final String fileFolder = "C:\\Images\\";
	private Logger i = new Logger();
	
	@Autowired
	private PictureService pictureService;

	@Autowired
	private CollectionService collectionService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/picture.action")
	public String picture(Integer id,Model model, HttpSession session){
		/**
		 * 通过数据库查找ID为id的图片名称
		 * 需要修改，资深医生发送不同判断的图片
		 */
		Picture picture = this.pictureService.findPictureById(id);
		DateFormat DFC = new DateFormat();
		picture.setDateS(DFC.Transform(picture.getDate()));
		if(session.getAttribute("img") != null){
			session.removeAttribute("img");
		}

		session.setAttribute("img", picture);
		return "picture_single";
	}
	@RequestMapping(value="/sumbitAxis.action", method = RequestMethod.POST)
	public String sumbitAxis(String pointx,String pointy,
			Model model, HttpSession session){
		int x = (int)Double.parseDouble(pointx);
		int y = (int)Double.parseDouble(pointy);
		System.out.println("数据已接收");
		System.out.println("X:" + pointx + ",Y:" + pointy);
		

		Picture picture = (Picture)session.getAttribute("img");
		User user = (User)session.getAttribute("user");
		if(picture == null) {
			System.out.println("NULL Point");
		}
		if(picture.getTimes() == 4){
			picture.setDoctor_pro(user.getId());
			picture.setPoint_y(x);
			picture.setPoint_x(y);
			//更新数据
			if(this.pictureService.updatePicture(picture)){
				List<Picture> lPicture = this.pictureService.findDischeck(user.getId());
				session.setAttribute("img", lPicture.get(0));
				return "picture_single";
			}else{
				return "error";
			}
			
		}
		
		//插入医生判断数据
		switch(picture.getTimes()){
			case 0:
				picture.setDoctor1(user.getId());
				picture.setPoint1_x(x);
				picture.setPoint1_y(y);
				picture.setTimes(1);
				break;
			case 1:
				picture.setDoctor2(user.getId());
				picture.setPoint2_x(x);
				picture.setPoint2_y(y);
				picture.setTimes(2);
				break;
			case 2:
				picture.setDoctor3(user.getId());
				picture.setPoint3_x(x);
				picture.setPoint3_y(y);
				picture.setTimes(3);
				break;
		}
		
		//判断是否需要资深医生做判断
		double i1 = -1;
		double i2 = -1;
		double i3 = -1;
		double distance = 5;		//坐标间距离的设置

		switch(picture.getTimes()){
			case 1:
				//判断(x1,y1)与(x2,y2)之间的距离
				i1 = Math.sqrt(Math.pow(picture.getPoint1_x() - picture.getPoint2_x(), 2) + Math.pow(picture.getPoint1_y() - picture.getPoint2_y(), 2));	
				if(i1 < distance){
					picture.setSame(true);
				}else{
					picture.setSame(false);
				}
				break;
			case 2:
				i1 = Math.sqrt(Math.pow(picture.getPoint1_x() - picture.getPoint2_x(), 2) + Math.pow(picture.getPoint1_y() - picture.getPoint2_y(), 2));
				i2 = Math.sqrt(Math.pow(picture.getPoint1_x() - picture.getPoint3_x(), 2) + Math.pow(picture.getPoint1_y() - picture.getPoint3_y(), 2));
				i3 = Math.sqrt(Math.pow(picture.getPoint3_x() - picture.getPoint2_x(), 2) + Math.pow(picture.getPoint3_y() - picture.getPoint2_y(), 2));
				if(i1 < distance && i2 < distance && i3 < distance){
					picture.setSame(true);
				}else{
					picture.setSame(false);
				}
				break;
		}
		//更新数据
		if(this.pictureService.updatePicture(picture)){
			List<Picture> lPicture = this.pictureService.findDischeck(user.getId());
			if (lPicture.get(0) != null) {
				session.setAttribute("img", lPicture.get(0));
				return "picture_single";
			}else {
				return "error";
			}
		}else{
			return "error";
		}
		
	}

	@RequestMapping(value="/sumbitAxisStudents.action", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> sumbitAxisStudents(String pointx,String pointy,
			Model model, HttpSession session){
		int x = (int)Double.parseDouble(pointx);
		int y = (int)Double.parseDouble(pointy);
		System.out.println("数据已接收(学生)");
		System.out.println("X:" + pointx + ",Y:" + pointy);
		Picture picture = (Picture)session.getAttribute("img");
		User user = (User)session.getAttribute("user");
		Map<String,String> m = new HashMap<String,String>();
		if (picture.getDoctor_pro() == 0) {
			m.put("doctor", "normal");
			m.put("x1", picture.getPoint1_x()+"");
			m.put("y1", picture.getPoint1_y()+"");
			m.put("x2", picture.getPoint2_x()+"");
			m.put("y2", picture.getPoint2_y()+"");
			m.put("x3", picture.getPoint3_x()+"");
			m.put("y3", picture.getPoint3_y()+"");
		}else {
			m.put("doctor", "pro");
			m.put("x", picture.getPoint_x()+"");
			m.put("y", picture.getPoint_y()+"");
		}

		return m;
	}
	@RequestMapping("AddPicture.action")
	@ResponseBody
	public String addPicture(@RequestParam("Picture")MultipartFile file,HttpServletRequest request) throws IOException{
		i.log("Adding...");
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		Picture picture = new Picture();
		String oldFileName = file.getOriginalFilename();
		String newFileName = UUIDGenerator.getUUID() + ".jpg";
		if (!oldFileName.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(fileFolder,newFileName));
			picture.setDate(new Date());
			picture.setSrc_image("http://localhost:8080/pictures/" + newFileName);
			pictureService.addPicture(picture);
			i.log("return OK");
			return "OK";
		}
		i.log("return Error");
		return "Error";
	}
	
	
//	@RequestMapping("comment.action")
//	public String comment( request, HttpSession session) {
//		String comment = request.getParameter("comment");
//		Comment co = new Comment();
//		co.setComment(comment);
//		User u = (User)session.getAttribute("user");
//		Picture p = (Picture)session.getAttribute("img");
//		co.setUser_id(u.getId());
//		co.setDate(new Date());
//		co.setPicture_id(p.getId());
//		this.commentService.addComment(co);
//
//		if(session.getAttribute("img") != null){
//			session.removeAttribute("img");
//		}
//		List<Comment> lComment = this.commentService.findPictureComments(p.getId());
//		List<Comment> lComment1 = new ArrayList<Comment>(); 
//		for (Comment c:lComment) {
//			User user = this.userService.findUserById(c.getUser_id());
//			c.setUser(user);
//			if(c.getDate() == null) {
//				c.setDate(new Date());
//			}
//			lComment1.add(c);
//		}
//		session.setAttribute("img", p);
//		session.setAttribute("lComment", lComment1);
//		return "picture";
//	}
	class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
