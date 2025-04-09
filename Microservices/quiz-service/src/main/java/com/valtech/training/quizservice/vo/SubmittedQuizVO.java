package com.valtech.training.quizservice.vo;

import java.util.List;

public class SubmittedQuizVO {
	
	List<QuestionResultVO> listOfAnswers;

	public List<QuestionResultVO> getListOfAnswers() {
		return listOfAnswers;
	}

	public void setListOfAnswers(List<QuestionResultVO> listOfAnswers) {
		this.listOfAnswers = listOfAnswers;
	}

	public SubmittedQuizVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubmittedQuizVO(List<QuestionResultVO> listOfAnswers) {
		super();
		this.listOfAnswers = listOfAnswers;
	}
	
	

}
