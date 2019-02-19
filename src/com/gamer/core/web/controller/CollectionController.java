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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gamer.common.utils.DateFormat;
import com.gamer.common.utils.Logger;
import com.gamer.core.po.*;
import com.gamer.core.service.*;
@Controller
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private UserService userService;
	DateFormat DFC = new DateFormat();

	
	@RequestMapping("/AddCollection.action")
	@ResponseBody
	public String addCollection(@RequestBody Map<String,String> map,HttpSession session) {
		String id = map.get("id");
		
		
		int pictureid = Integer.parseInt(id);
		Logger.log("AddCollection...");
		User u = (User)session.getAttribute("user");
		collectionService.addCollection(u.getId(), pictureid);
		
		return "OK";
	}
	@RequestMapping("/RemoveCollection.action")
	@ResponseBody
	public String removeCollection(@RequestBody Map<String,String> map,HttpSession session) {
		String id = map.get("id");
		
		int pictureid = Integer.parseInt(id);
		Logger.log("RemoveCollection...");
		User u = (User)session.getAttribute("user");
		collectionService.removeCollection(u.getId(), pictureid);
		
		return "OK";
	}
	@RequestMapping("/collection.action")
	public String findCollection(HttpSession session) {
		User u = (User)session.getAttribute("user");
		List<Picture> lPicture = collectionService.findAllCollection(u.getId());
		

		for (Picture picture:lPicture) {
			picture.setIsCollection("取消收藏");
			picture.setDateS(DFC.Transform(picture.getDate()));
		}
		session.setAttribute("listPicture", lPicture);
		Logger.log("findCollection...");
		session.setAttribute("collectionPicture", lPicture);
		
		return "collection";
	}
}
