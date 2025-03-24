package com.valtech.training.resultservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.resultservice.vos.AttemtedQuizVO;
import com.valtech.training.resultservice.vos.QuestionResultVO;
import com.valtech.training.resultservice.vos.QuestionVO;
import com.valtech.training.resultservice.vos.QuizVO;

@Service
public class ResultServiceImpl implements ResultService {
	
	//public QuizVO 
	
	@Autowired
	private QuizClient quizClient;
	
	@Override
	public float calculateResult(QuizVO vo1){
		
		
		vo1.getQuestionResultVOs()
		
		
		for( QuestionResultVO questionResultVO: vo1.getQuestionResultVOs()) {
			questionResultVO.
		}
		
		vo1.get
		String[] answers=vo1.getSubmittedAnswers();
		QuizVO vo=quizClient.getQuiz(id);
		int i=0;
		float score=0;
		for(QuestionVO q:vo.questionIds()) {
			if(q.correctOption().equals(answers[i])) {
				score+=5;
			}i++;
		}
		return score;
	}
	

}
