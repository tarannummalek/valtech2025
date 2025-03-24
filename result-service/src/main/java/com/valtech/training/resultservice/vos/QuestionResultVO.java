package com.valtech.training.resultservice.vos;

public class QuestionResultVO {
	
	private long id;
	
	private long questionId;
	
	private String userAnswer;
	
	private boolean result;
	
	private long quiz_id;

	public QuestionResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionResultVO(long id, long questionId, String userAnswer, boolean result, long quiz_id) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.result = result;
		this.quiz_id = quiz_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public long getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(long quiz_id) {
		this.quiz_id = quiz_id;
	}
	
	
	
}
