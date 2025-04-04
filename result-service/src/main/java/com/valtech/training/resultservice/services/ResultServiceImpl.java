package com.valtech.training.resultservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.resultservice.vos.QuestionResultVO;
import com.valtech.training.resultservice.vos.QuestionVO;
import com.valtech.training.resultservice.vos.QuizVO;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private QuestionClient questionClient;
    
    @Override
    public float calculateResult(QuizVO vo1) {

        List<QuestionResultVO> questionResults = vo1.getQuestionResultVOs();
        float score = 0;
        for (QuestionResultVO questionResultVO : questionResults) {
            long questionId = questionResultVO.getQuestionId(); 
            String userAnswer = questionResultVO.getUserAnswer(); 
            try {
                QuestionVO questionVO = questionClient.getQuestion(questionId);
                if (questionVO == null) {
                    System.err.println("Question not found: id= " + questionId);
                }
                if (questionVO.correctOption() != null && questionVO.correctOption().equals(userAnswer)) {
                    score += 5;
                }

            } catch (Exception e) {
                System.err.println("ERROR WHILE FETCHING " + questionId);
                e.printStackTrace();
            }
        }
        return score;
    }
}
