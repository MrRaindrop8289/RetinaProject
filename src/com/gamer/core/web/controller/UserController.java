package com.gamer.core.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamer.common.utils.DateFormat;
import com.gamer.common.utils.Logger;
import com.gamer.core.po.*;
import com.gamer.core.service.*;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private CollectionService collectionService;
	
	DateFormat DFC = new DateFormat();
	
	/**
	 * 跳转至登陆页面
	 */
	@RequestMapping("toLogin.action")
	public String toLogin() {
		return "login";
		
	}
	/**
	 * @param account
	 * @param password
	 * @param model
	 * @param session
	 * @return
	 * 
	 * 登陆用户
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String account,String password,Model model, HttpSession session){
		User user = this.userService.findUserByAccount(account);
		if(user != null){
			if(password.equals(user.getPassword())){
				System.out.println("登陆成功");
				user.setDateS(DFC.Transform(user.getDate()));
				session.setAttribute("user", user);
				if (!user.isPermission()) {
					List<Picture> lPicture = new ArrayList<Picture>();
					if (user.getGrade() == 3) {
						lPicture = this.pictureService.findStudentPicture();
					}else {
						lPicture = this.pictureService.findDischeck(user.getId());
					}
					List<Integer> collection_p = collectionService.findPictureByUserId(user.getId());
					for (Picture picture:lPicture) {
						if (collection_p.contains(picture.getId())) {
							picture.setIsCollection("取消收藏");
						}else {
							picture.setIsCollection("收藏");
						}
						picture.setDateS(DFC.Transform(picture.getDate()));
					}
					session.setAttribute("listPicture", lPicture);
					String date = DFC.Transform(new Date());
					session.setAttribute("date", date);
				}
				return "main";
			}else{
				System.out.println("登陆失败");
				model.addAttribute("msg", "账号或密码错误，请重新输入！");
				return "login";
			}
		}else{
			System.out.println("登陆失败");
			model.addAttribute("msg", "账号或密码错误，请重新输入！");
			return "login";
		}
		
	}
	/**
	 * 跳转至注册页面	
	 */
	@RequestMapping("/toRegistUser.action")
	public String toRegist() {
		return "regist";
	}
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	/**
	 *  密保问题：
	 *   Question.0 密保问题
		 Question.1 小学就读于哪里？
		 Question.2 初中就读于哪里？
		 Question.3 高中就读于哪里？
		 Question.4 大学就读于哪里？
		 Question.5 我的第一辆车是什么？
		 Question.6 我的初恋是谁？
		 Question.7 我是男是女？
	 * @param user
	 * @return
	 */
	@RequestMapping("/registUser.action")
	@ResponseBody
	public String registUser(@RequestBody User user){
		System.out.println("Regist User!");
		User u1 = this.userService.findUserByAccount(user.getAccount());
		if(u1 != null){
			System.out.println("用户已存在");
			return "2";
		}else{
			user.setHead_src("images/1.jpg");
			user.setPermission(false);
			user.setGrade(3);
			user.setSignature("该用户很懒，还没有签名");
			user.setDate(new Date());
			System.out.println(user);
			int row = this.userService.saveUser(user);
			if(row > 0){
				System.out.println("注册成功");
				return "1";			
			}else{
				System.out.println("注册失败");
				return null;
			}
		}
	}
	/**
	 * 跳转至找回密码页面
	 */
	@RequestMapping("/toFindUser.action")
	public String toFindUser() {
		return "findUser";
	}
	/**
	 * 找回密码
	 * @param user
	 * @return
	 */
	@RequestMapping("/findUser.action")
	@ResponseBody
	public String findUser(@RequestBody User user){
		User u1 = this.userService.findUserByAccount(user.getAccount());
		System.out.println("FindUser!");
		if(u1 == null){
			System.out.println("User is not Regist!");
			return "NoUser";
		}else {
			if(user.getQuestion() == u1.getQuestion() && user.getAnswer().equals(u1.getAnswer())){
				return u1.getPassword();
			}else{
				System.out.println("FindUser Error!");
				return null;
			}
		}
			
	}
	
	//页面跳转
	@RequestMapping("/main.action")
	public String main(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (!user.isPermission()) {
			List<Picture> lPicture = new ArrayList<Picture>();
			if (user.getGrade() == 3) {
				lPicture = this.pictureService.findStudentPicture();
			}else {
				lPicture = this.pictureService.findDischeck(user.getId());
			}
			List<Integer> collection_p = collectionService.findPictureByUserId(user.getId());
			for (Picture picture:lPicture) {
				if (collection_p.contains(picture.getId())) {
					picture.setIsCollection("取消收藏");
				}else {
					picture.setIsCollection("收藏");
				}
				picture.setDateS(DFC.Transform(picture.getDate()));
			}
			session.setAttribute("listPicture", lPicture);
			String date = DFC.Transform(new Date());
			session.setAttribute("date", date);
		}
		return "main";
	}

	//登出页面
	@RequestMapping("/logout.action")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	//修改用户名
	@RequestMapping("/changeUserName.action")
	@ResponseBody
	public String changeUserName(HttpSession session,@RequestBody Map<String,String> map) {
		Logger.log("ChangeUserNameing...");
		String name=map.get("name");
		User u = (User)session.getAttribute("user");
		userService.changeUserName(u, name);
		u.setName(name);
		session.setAttribute("user", u);
		return "OK";
	}
	//修改用户签名
	@RequestMapping("/changeUserSignature.action")
	@ResponseBody
	public String changeUserSignature(HttpSession session,@RequestBody Map<String,String> map) {
		Logger.log("ChangeUserSignatureing...");
		String signature=map.get("signature");
		User u = (User)session.getAttribute("user");
		userService.changeSignature(u, signature);
		u.setSignature(signature);
		session.setAttribute("user", u);
		return "OK";
	}
	//用户修改页面
	@RequestMapping("/User.action")
	public String UserPage() {
		return "user";
	}
}
