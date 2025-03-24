package com.valtech.training.resultservice.vos;

import java.util.List;

public class QuizVO{
	long id;
	String name;
	float maxScore;
	float duration;
	List<QuestionVO> questionIds;
	List<QuestionResultVO> questionResultVOs;
	public QuizVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizVO(long id, String name, float maxScore, float duration, List<QuestionVO> questionIds,
			List<QuestionResultVO> questionResultVOs) {
		super();
		this.id = id;
		this.name = name;
		this.maxScore = maxScore;
		this.duration = duration;
		this.questionIds = questionIds;
		this.questionResultVOs = questionResultVOs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(float maxScore) {
		this.maxScore = maxScore;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public List<QuestionVO> getQuestionIds() {
		return questionIds;
	}
	public void setQuestionIds(List<QuestionVO> questionIds) {
		this.questionIds = questionIds;
	}
	public List<QuestionResultVO> getQuestionResultVOs() {
		return questionResultVOs;
	}
	public void setQuestionResultVOs(List<QuestionResultVO> questionResultVOs) {
		this.questionResultVOs = questionResultVOs;
	}
	



}
