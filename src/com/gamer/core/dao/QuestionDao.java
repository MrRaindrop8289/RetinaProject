package com.gamer.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gamer.core.po.Question;

public interface QuestionDao {
	public List<Question> findAllQuestion();
	public Question findQuestionById(Integer id);
	public Question findQuestionByTitle(@Param("title")String title);
	public void addQuestion(@Param("q")Question q);
}
