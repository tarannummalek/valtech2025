package com.valtech.training.questionservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.repos.QuestionRepo;
import com.valtech.training.questionservice.vos.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO createQuestion(QuestionVO questionVO) {
		return QuestionVO.from(questionRepo.save(questionVO.to()));
	}
	
	@Override
	public QuestionVO updateQuestion(QuestionVO questionVO,long id) {
		Question vo =questionRepo.getReferenceById(id);
		vo.setOption1(questionVO.option1());
		vo.setOption2(questionVO.option2());
		vo.setOption3(questionVO.option3());
		vo.setOption4(questionVO.option4());
		vo.setCorrectOption(questionVO.correctOption());
		vo.setQuestionText(questionVO.queText());
		return QuestionVO.from(questionRepo.save(vo));
	}
	
	@Override
	public List<QuestionVO> getAllQuestions(){
		return questionRepo.findAll().stream().map(q->QuestionVO.from(q)).toList();
	}
	
	@Override
	public QuestionVO getQuestionById(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getQuestionsByTopic(String topic){
		return questionRepo.findAllByTopic(topic) .stream().map(q->QuestionVO.from(q)).toList();
	}

}
