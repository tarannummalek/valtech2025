package com.valtech.training.quizservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.services.QuizService;
import com.valtech.training.quizservice.vo.QuestionResultVO;
import com.valtech.training.quizservice.vo.QuizVO;
import com.valtech.training.quizservice.vo.SubmittedQuizVO;



@RestController
@RequestMapping("/quizes")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	private QuizVO createqQuiz(@RequestBody QuizVO vo) {
		
		return quizService.createquiz(vo);
		
	}
	@GetMapping("/{id}")
	private QuizVO getQuiz(@PathVariable long id) {
	return quizService.getQuiz(id);
		
	}
	
	@PostMapping("/attemtQuiz")
	public QuizVO submitQuiz(@RequestBody SubmittedQuizVO submittedQuizVO) {
		return quizService.submitAnswers(submittedQuizVO);
				
	}
}
