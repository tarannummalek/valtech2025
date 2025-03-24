package com.valtech.training.quizservice.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class QuestionResult {
	
	private long id;
	
	private long questionId;
	
	private String userAnswer;
	
	private boolean result;
	
	@ManyToOne(targetEntity = Quiz.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "quiz_id", referencedColumnName = "id")
	private Quiz quiz;

	public QuestionResult() {
	}

	public QuestionResult(long id, Quiz quiz, long questionId, String userAnswer, boolean result) {
		super();
		this.id = id;
		this.quiz = quiz;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.result = result;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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
	
	
	

}
