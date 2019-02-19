package com.gamer.core.po;

/**
 * 问答精灵
 */
import java.util.List;

public class QuestionAndAnswer {
	private Question question;			//问题
	private List<Answer> ListAnswer;	//回答列表
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getListAnswer() {
		return ListAnswer;
	}
	public void setListAnswer(List<Answer> listAnswer) {
		ListAnswer = listAnswer;
	}
	
	@Override
	public String toString() {
		return "QuestionAndAnswer [question=" + question + ", ListAnswer=" + ListAnswer + "]";
	}
	
}
