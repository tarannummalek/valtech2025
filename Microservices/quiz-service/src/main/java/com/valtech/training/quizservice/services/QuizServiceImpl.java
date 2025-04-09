package com.valtech.training.quizservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vo.QuestionResultVO;
import com.valtech.training.quizservice.vo.QuestionVO;
import com.valtech.training.quizservice.vo.QuizVO;
import com.valtech.training.quizservice.vo.SubmittedQuizVO;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	QuestionClient questionClient;
	
	@Override
	public QuizVO createquiz(QuizVO quizVO) {
		QuizVO quizVO1=QuizVO.from( quizRepo.save(quizVO.to()));
		List<QuestionVO> volist=questionClient.getQuestions(quizVO.getName());
		//List<Long> questioIds=volist.stream().map(q->q.id()).collect(Collectors.toList());
	quizVO1.setQuestionIds(volist);
	return quizVO1;
	}
	
	@Override
	public QuizVO getQuiz(long id) {
		QuizVO quizVO1=QuizVO.from(quizRepo.getReferenceById(id));
		List<QuestionVO> volist=questionClient.getQuestions(quizVO1.getName());
		//List<Long> questioIds=volist.stream().map(q->q.id()).collect(Collectors.toList());
	quizVO1.setQuestionIds(volist);
	return quizVO1;
		
	}
	
	@Override
	public QuizVO submitAnswers(SubmittedQuizVO submittedQuizVO) {		
		List<QuestionResultVO> answers=submittedQuizVO.getListOfAnswers();
		int score=0;
//		for(QuestionResultVO qVO: answers) {
//			if(qVO.getUserAnswer()==questionClient.getQuestion(qVO.getQuestionId()).correctOption()) {
//				score+=10;
//			}
//		}
		QuizVO quizVO=QuizVO.from(quizRepo.getReferenceById(submittedQuizVO.getListOfAnswers().get(0).getQuiz_id()));
		if(quizVO.getQuestionResultVOs()==null)quizVO.setQuestionResultVOs(new ArrayList<QuestionResultVO>());
		quizVO.setQuestionResultVOs(quizVO.getQuestionResultVOs());
		return quizVO;
	}
	
	

}
