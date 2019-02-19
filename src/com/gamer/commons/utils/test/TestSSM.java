package com.gamer.commons.utils.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.ui.Model;

import com.gamer.common.utils.*;
import com.gamer.core.dao.*;
import com.gamer.core.po.*;
import com.gamer.core.service.*;
import com.gamer.core.web.controller.*;
import com.gamer.test.ReadAllFiles;


public class TestSSM extends TestCase{
	@Resource
	PictureService pictureService;
	@Resource
	UserService userService;
	@Resource
	QuestionService questionService;
	@Resource
	CollectionService collectionService;
	@Resource
	CollectionDao collectionDao;
	@Resource
	PictureDao pictureDao;
	@Resource
	UserDao userDao;
	
	
	DateFormat DFC = new DateFormat();
	
	@Test
	public void Test() {
		List<Question> lQuestion = this.questionService.findAllQuestion();
		System.out.println("question.qction");
		for (Question q:lQuestion) {
			q.setUser(userService.findUserById(q.getUser_id()));
			System.out.println("Question_Id:" + q.getId() + ";" + "User_id:" + userService.findUserById(q.getUser_id()).getId());
			q.setDateS(DFC.Transform(q.getDate()));
		}
		System.out.println("Size:" + lQuestion.size());
	}
	@Test
	public void PictureTest() {
		User u = userService.findUserById(1);
		System.out.println(u.isPermission());
	}
	

	@Test
	@Rollback(false)
	public void CollectionTest() {
		collectionService.removeCollection(1, 1);
	}
	@Test
	@Rollback(false)
	public void findAllCollectionTest() {
		List<Collections> lPictureId = collectionDao.findAllCollectionByPicture(2);

		List<Picture> lPicture = new ArrayList<Picture>();
		for (Collections i:lPictureId) {
			Picture p = pictureDao.findPictureById(i.getPicture_id());
			p.setDateS(DateFormat.Transform(i.getDate()));
			lPicture.add(p);
		}
	}
	@Test
	@Rollback(false)
	public void AddPicture() {
		ArrayList<String> filenames = ReadAllFiles.getFiles("C:\\Users\\Raindrop\\Desktop\\20160506\\20160506尺寸未修改原版尺寸");
		for (String s: filenames) {
			Picture p = new Picture();
			p.setSrc_image(s);
			p.setDate(new Date());
			pictureService.addPicture(p);
		}
		System.out.println("Add Over");
	}
	
	@Test
	@Rollback(false)
	public void InitTableUser () {
		userDao.truncateTableUser();
		List<User> lUser = new ArrayList<User>();
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		User u4 = new User();
		u1.setAccount("admin");
		u2.setAccount("doctor1");
		u3.setAccount("doctor2");
		u4.setAccount("doctor3");
		u1.setName("admin");
		u2.setName("doctor1");
		u3.setName("doctor2");
		u4.setName("doctor3");
		u2.setSex("man");
		u3.setSex("woman");
		u4.setSex("man");
		u4.setGrade(2);
		u2.setGrade(2);
		u3.setGrade(2);
		lUser.add(u1);
		lUser.add(u2);
		lUser.add(u3);
		lUser.add(u4);
		for (User u :lUser) {
			u.setHead_src("images/1.jpg");
			u.setPassword("123");
			if (!u.getAccount().equals("admin")) {
				u.setPermission(false);
			}else {
				u.setPermission(true);
			}
			u.setQuestion(1);
			u.setAnswer("eclipse");
			u.setSignature("该用户很懒，还没有签名");
			u.setDate(new Date());
			userDao.saveUser(u);
		}
	}
	
	
	@Test
	public void findCollection() {
		List<Integer> t = collectionService.findPictureByUserId(6);
		for (Integer i: t) {
			System.out.println(i);
		}
		if (t.contains(4)) {
			System.out.println("Contains 4.");
		}
		
	}
	@Test
	@Rollback(false)
	public void changeUserSignature() {
		User u = new User();
		u.setId(5);
		String signature = "井蛙不可语于海，夏虫不可语于冰。";
		userService.changeSignature(u, signature);
		
	}
}