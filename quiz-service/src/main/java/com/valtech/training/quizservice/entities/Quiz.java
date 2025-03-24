package com.valtech.training.quizservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Quiz {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq",sequenceName = "quiz_seq",allocationSize = 1)
	private long id;
	
	private String name;
	
	private float duration;
	
	private float maxScore;
	
	@OneToMany(targetEntity = QuestionResult.class,mappedBy = "quiz",fetch = FetchType.LAZY)
	private List<QuestionResult> questionResults;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(String name, float duration, float maxScore) {
		super();
		this.name = name;
		this.duration = duration;
		this.maxScore = maxScore;
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

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(float maxScore) {
		this.maxScore = maxScore;
	}

	public List<QuestionResult> getQuestionResults() {
		return questionResults;
	}

	public void setQuestionResults(List<QuestionResult> questionResults) {
		this.questionResults = questionResults;
	}
	
	void addQuestionResult(QuestionResult questionResult) {
		if(questionResults==null) new ArrayList<>();
		questionResults.add(questionResult);
		questionResult.setQuiz(this);
	}
	
	

}
