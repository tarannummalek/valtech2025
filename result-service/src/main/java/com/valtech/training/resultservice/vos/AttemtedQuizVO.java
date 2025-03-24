package com.valtech.training.resultservice.vos;

public class AttemtedQuizVO {
	
	private String[] submittedAnswers;

	public AttemtedQuizVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttemtedQuizVO(String[] submittedAnswers) {
		super();
		this.submittedAnswers = submittedAnswers;
	}

	public String[] getSubmittedAnswers() {
		return submittedAnswers;
	}

	public void setSubmittedAnswers(String[] submittedAnswers) {
		this.submittedAnswers = submittedAnswers;
	}
	
	

}
