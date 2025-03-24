package com.valtech.training.quizservice.services;

import com.valtech.training.quizservice.vo.QuestionResultVO;
import com.valtech.training.quizservice.vo.QuizVO;
import com.valtech.training.quizservice.vo.SubmittedQuizVO;

public interface QuizService {

	QuizVO createquiz(QuizVO quizVO);

	QuizVO getQuiz(long id);

	QuizVO submitAnswers(SubmittedQuizVO submittedQuizVO);

}