package com.valtech.training.resultservice.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.resultservice.vos.QuestionVO;

@Component
public class QuestionClient {
    
    public QuestionVO getQuestion(long questionId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9040/questions/"+ questionId;
        try {
            return restTemplate.getForObject(url, QuestionVO.class);
        } catch (Exception e) {
            System.err.println("ID NOT PRESENT"
            		+ "" + questionId);
            e.printStackTrace();
            return null;
        }
    }
}
