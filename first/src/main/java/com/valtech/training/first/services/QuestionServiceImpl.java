package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.QuestionRepo;
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question saveQuestion(Question question) {
		System.out.println("repo clas"+questionRepo.getClass().getName());
		return questionRepo.save(question);
	}
	@Override
	public Question updateQuestion(Question question) {
		System.out.println("repo clas"+questionRepo.getClass().getName());
		return questionRepo.save(question);
	}
	@Override
	public Question getQuestion(Long id) {
		return questionRepo.getReferenceById(id);
	}
	
	@Override
	public void deleyteQuestion(Question question) {
		questionRepo.delete(question);
	}
	
	@Override
	public List<Question> getAllQuestions(){
		return questionRepo.findAll();
	}
	@Override
	public long count() {
		return questionRepo.count();
	}
	@Override
	public List<Question> getAllQuestionsBytopic(String topic) {
		// TODO Auto-generated method stub
		return questionRepo.findAllByTopic(topic);
	}
	@Override
	public long countByTopic(String topic) {
		// TODO Auto-generated method stub
		return questionRepo.countByTopic(topic);
	}
	@Override
	public long countByTopicAndQuestionTextContaining(String topic, String keyWord) {
		// TODO Auto-generated method stub
		return questionRepo.countByTopicAndQuestionTextContaining(topic,keyWord);
	}
	@Override
	public long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyWord) {
		// TODO Auto-generated method stub
		return questionRepo.countByTopicAndQuestionTextContainingIgnoreCase(topic, keyWord);
	}
	@Override
	public List<Question> getAllQuestionsBytopic(String topic, int page, int size) {
		// TODO Auto-generated method stub
		return questionRepo.findAllByTopic(topic,Pageable.ofSize(size).withPage(page));
	}
	

}
