package com.valtech.training.quizservice.controlllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quizservice.vo.QuizVO;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizControllerTests {

	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCreateLeave() {
		String url="http://localhost:"+port+"/quizes/";
		QuizVO vo=restTemplate.postForObject(url+"apply", new QuizVO(0,"programming languages", 20.0F,30.0F,null),QuizVO.class);
		assertEquals(0, vo.getId());
		assertEquals(1, vo.getQuestionIds().size());

	}

}
