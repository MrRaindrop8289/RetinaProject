package com.gamer.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamer.core.dao.AnswerDao;
import com.gamer.core.dao.UserDao;
import com.gamer.core.po.Answer;
import com.gamer.core.po.User;
import com.gamer.core.service.AnswerService;

@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerDao dao;
	
	@Autowired
	UserDao UDao;

	@Override
	public List<Answer> findAllAnswerById(Integer QuestionId) {
		// TODO Auto-generated method stub
		List<Answer> lAnswer = dao.findAllAnswerById(QuestionId);
		List<Answer> lAnswer1 = new ArrayList<Answer>();
		User user = new User();
		for (Answer a: lAnswer) {
			user = UDao.findUserById(a.getUser_id());
			a.setUser(user);
			lAnswer1.add(a);
		}
		if (lAnswer == null) {
			Answer a = new Answer();
			a.setAnswer("无回答");
		}
		return lAnswer1;
	}

	@Override
	public void addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		dao.addAnswer(answer);
		
	}

	@Override
	public void updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		dao.updateAnswer(answer);
	}

	@Override
	public void addLikes(Answer answer) {
		// TODO Auto-generated method stub
		dao.addLikes(answer);
	}

}
