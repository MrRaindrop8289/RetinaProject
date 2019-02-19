package com.gamer.core.service;

import java.util.List;
import com.gamer.core.po.*;

public interface QuestionService {
	public List<Question> findAllQuestion();
	public Question findQuestionById(Integer id);
	public Question findQuestionByTitle(String title);
	public void addQuestion(Question q);
}
