package com.valtech.training.resultservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.valtech.training.resultservice.services.QuizClient;
import com.valtech.training.resultservice.services.ResultService;
import com.valtech.training.resultservice.vos.AttemtedQuizVO;
import com.valtech.training.resultservice.vos.QuizVO;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private QuizClient quizClient;

    @PostMapping("/{id}")
    public float calculateScore(@RequestBody AttemtedQuizVO submittedAnswers, @PathVariable long id) {
        QuizVO quizVO = quizClient.getQuiz(id);

        if (quizVO == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        quizVO.setQuestionResultVOs(submittedAnswers.getQuestionResultVOs());
        return resultService.calculateResult(quizVO);
    }
}
