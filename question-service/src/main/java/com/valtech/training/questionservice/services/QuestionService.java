package com.valtech.training.questionservice.services;

import java.util.List;

import com.valtech.training.questionservice.vos.QuestionVO;

public interface QuestionService {

	QuestionVO createQuestion(QuestionVO questionVO);

	QuestionVO updateQuestion(QuestionVO questionVO, long id);

	List<QuestionVO> getAllQuestions();

	QuestionVO getQuestionById(long id);

	List<QuestionVO> getQuestionsByTopic(String topic);

}