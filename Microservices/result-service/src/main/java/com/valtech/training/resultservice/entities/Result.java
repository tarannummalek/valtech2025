package com.valtech.training.resultservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Result {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "resultseq")
	@SequenceGenerator(name = "result_seq",sequenceName = "resultseq")
	private long id;
	private long quizId;
	private float score;
	private float percentage;
	public Result() {
	}
	public Result(long id, long quizId, float score, float percentage) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.score = score;
		this.percentage = percentage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
	

}
