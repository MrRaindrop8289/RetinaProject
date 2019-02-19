package com.gamer.core.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamer.common.utils.DateFormat;
import com.gamer.common.utils.Logger;
import com.gamer.core.po.Answer;
import com.gamer.core.po.Question;
import com.gamer.core.po.User;
import com.gamer.core.service.AnswerService;
import com.gamer.core.service.QuestionService;
import com.gamer.core.service.UserService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	UserService userService;
	
	DateFormat DFC = new DateFormat();
	
	@RequestMapping("question.action")
	public String question(HttpSession session) {
		List<Question> lQuestion = this.questionService.findAllQuestion();
		Logger.log("question.qction");
		for (Question q:lQuestion) {
			q.setUser(userService.findUserById(q.getUser_id()));
			q.setDateS(DFC.Transform(q.getDate()));
		}
		session.setAttribute("lQuestion", lQuestion);
		return "question";
	}
	
	@RequestMapping("questionSingle.action")
	public String QuestionMore(Integer id, HttpSession session) {
		Question q = this.questionService.findQuestionById(id);
		Logger.log("questionSingle.qction");
		q.setUser(userService.findUserById(q.getUser_id()));
		q.setDateS(DFC.Transform(q.getDate()));
		session.setAttribute("question", q);
		
		List<Answer> lAnswer = answerService.findAllAnswerById(q.getId());
		session.setAttribute("lAnswer", lAnswer);
		return "question_single";
	}
	
	@RequestMapping("answer.action")
	public String answer(HttpServletRequest request,String wcontent, HttpSession session) {
		String wcontent1 = request.getParameter("wcontent");
		Logger.log("answer.qction");
		Logger.log("wcontent  :" + wcontent);
		Logger.log("wcontent1 :" + wcontent1);
		Answer answer = new Answer();
		Question question = (Question)session.getAttribute("question");
		User user = (User)session.getAttribute("user");
		answer.setAnswer(wcontent);
		answer.setUser_id(user.getId());
		answer.setQuestion_id(question.getId());
		answer.setDate(new Date());
		
		answerService.addAnswer(answer);

		List<Answer> lAnswer = answerService.findAllAnswerById(question.getId());
		for (Answer a:lAnswer) {
			a.setUser(userService.findUserById(a.getUser_id()));
			a.setDateS(DFC.Transform(a.getDate()));
		}
		session.setAttribute("lAnswer", lAnswer);
		return "question_single";
	}
	
	@RequestMapping("addQuestion.action")
	@ResponseBody
	public String addQuestion(@RequestBody()Question aQuestion,HttpSession session){
		System.out.println("QuestionAdd");
		Map<String,String> m = new HashMap<String,String>();
		ObjectMapper oMapper = new ObjectMapper();
		User u = (User)session.getAttribute("user");
		aQuestion.setUser_id(u.getId());
		aQuestion.setDate(new Date());
		Question title = questionService.findQuestionByTitle(aQuestion.getQuestion());
		if (title != null) {
			m.put("type","same");
			m.put("questionid", title.getId()+"");
		}else {
			m.put("type", "NotSame");
			questionService.addQuestion(aQuestion);
			m.put("questionid", questionService.findQuestionByTitle(aQuestion.getQuestion()).getId()+"");
		}
		try {
			return oMapper.writeValueAsString(m);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("addQuestionIndex.action")
	public String addQuestionIndex() {
		return "question_add";
	}
}
