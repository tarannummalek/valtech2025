package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Question;

public interface QuestionService {

	Question saveQuestion(Question question);

	Question updateQuestion(Question question);

	Question getQuestion(Long id);

	void deleyteQuestion(Question question);

	List<Question> getAllQuestions();
	
	
	long count();
	
	List<Question> getAllQuestionsBytopic(String topic);
	
	List<Question> getAllQuestionsBytopic(String topic,int page,int size);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyWord);

	long countByTopicAndQuestionTextContainingIgnoreCase(String string, String string2);

}