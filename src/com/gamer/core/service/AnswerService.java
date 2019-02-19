package com.gamer.core.service;

import java.util.List;
import com.gamer.core.po.*;

public interface AnswerService {
	public List<Answer> findAllAnswerById(Integer QuestionId);
	public void addAnswer(Answer answer);
	public void updateAnswer(Answer answer);
	public void addLikes(Answer answer);
}
