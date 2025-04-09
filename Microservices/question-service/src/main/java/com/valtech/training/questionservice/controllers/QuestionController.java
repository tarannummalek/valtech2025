package com.valtech.training.questionservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.services.QuestionService;
import com.valtech.training.questionservice.vos.QuestionVO;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.createQuestion(questionVO);
	}
	
	@PutMapping("/{id}")
	public QuestionVO updateQuestion(@RequestBody QuestionVO questionVO,@PathVariable long id) {
		return questionService.updateQuestion(questionVO, id);
	}
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestionById(@PathVariable long id) {
		return questionService.getQuestionById(id);
	}
	
	@GetMapping("/q/{topic}")
	public List<QuestionVO> getQuestionsByTopic(@PathVariable String topic){
		return questionService.getQuestionsByTopic(topic);
	}

}
