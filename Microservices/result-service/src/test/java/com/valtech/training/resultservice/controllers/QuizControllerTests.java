package com.valtech.training.resultservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.resultservice.vos.AttemtedQuizVO;
import com.valtech.training.resultservice.vos.QuestionResultVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ResultControllerTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testCalculateScore() {
        long questionId1 = 1;
        long questionId2 = 2;
        long questionId3 = 3;

        AttemtedQuizVO attemptedQuizVO = new AttemtedQuizVO();
        attemptedQuizVO.setQuestionResultVOs(List.of(
            new QuestionResultVO(1, questionId1, "A", false, 1, "A"),  //  "A" is the correct answer for questionId1
            new QuestionResultVO(2, questionId2, "B", false, 1, "B"),  
            new QuestionResultVO(3, questionId3, "C", false, 1, "C")   
        ));

        String url = "http://localhost:" + port + "/result/1";

        float score = restTemplate.postForObject(url, attemptedQuizVO, Float.class);

        assertEquals(15.0, score);
    }
}
