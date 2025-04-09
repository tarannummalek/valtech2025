package com.valtech.training.quizservice.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.valtech.training.quizservice.entities.Quiz;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizVO{
	private long id;
	private String name;
	private float maxScore;
	private float duration;
	private List<QuestionVO> questionIds;
	private List<QuestionResultVO> questionResultVOs;


	public static QuizVO from(Quiz quiz) {
		return new QuizVO(quiz.getId(), quiz.getName(), quiz.getMaxScore(), quiz.getDuration(),null);
	}
	
	public Quiz to() {
		Quiz quiz= new Quiz(name, duration, maxScore);
		quiz.setId(id);
		return quiz;
	}

	public QuizVO() {
	}

	public QuizVO(long id, String name, float maxScore, float duration, List<QuestionVO> questionIds) {
		super();
		this.id = id;
		this.name = name;
		this.maxScore = maxScore;
		this.duration = duration;
		this.questionIds = questionIds;
	}
	public QuizVO(long id, String name, float maxScore, float duration) {
		super();
		this.id = id;
		this.name = name;
		this.maxScore = maxScore;
		this.duration = duration;
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
	
	public void addQuestionResult(QuestionResultVO questionResultVO) {
		if(questionResultVOs==null)questionResultVOs.add(questionResultVO);
		questionResultVO.setQuiz_id(id);
	}

//	public QuizVO addQuestionResult(QuestionResultVO questionResultVO) {
//		if(this.questionResultVOs==null)questionResultVOs=new ArrayList<QuestionResultVO>(); 
//			questionResultVOs.add(questionResultVO);
//		}
//	}
	
}
	
	

