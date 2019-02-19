package com.gamer.core.dao;

import java.util.List;

import com.gamer.core.po.Answer;

public interface AnswerDao {
	public List<Answer> findAllAnswerById(Integer QuestionId);
	public void addAnswer(Answer answer);
	public void updateAnswer(Answer answer);
	public void addLikes(Answer answer);
}
