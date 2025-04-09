package com.valtech.training.resultservice.services;

import com.valtech.training.resultservice.vos.AttemtedQuizVO;
import com.valtech.training.resultservice.vos.QuizVO;

public interface ResultService {

	float calculateResult(QuizVO vo);
	

}