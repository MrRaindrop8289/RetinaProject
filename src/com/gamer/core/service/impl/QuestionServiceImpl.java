package com.gamer.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamer.core.dao.QuestionDao;
import com.gamer.core.dao.UserDao;
import com.gamer.core.po.Question;
import com.gamer.core.po.User;
import com.gamer.core.service.QuestionService;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionDao dao;
	
	@Autowired
	UserDao UDao;
	
	@Override
	public List<Question> findAllQuestion() {
		List<Question> lQuestion = dao.findAllQuestion();
		return lQuestion;
	}

	@Override
	public Question findQuestionById(Integer id) {
		// TODO Auto-generated method stub
		Question q = dao.findQuestionById(id);
		User u = new User();
		u = UDao.findUserById(q.getUser_id());
		q.setUser(u);
		return q;
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		dao.addQuestion(q);
	}

	@Override
	public Question findQuestionByTitle(String title) {
		// TODO Auto-generated method stub
		
		return dao.findQuestionByTitle(title);
	}

}
