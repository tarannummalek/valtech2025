package com.valtech.training.resultservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.valtech.training.resultservice.vos.AttemtedQuizVO;
import com.valtech.training.resultservice.vos.QuizVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ResultControllerTests {

	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCalculateScore() {
		int qId=1;
		String url="http://localhost:"+port+"/quizes/1";
		//QuizVO vo=restTemplate.getForObject(url,QuizVO.class);
		String url2="http://localhost:"+port+"/result/"+qId;
//		MultiValueMap<String,Object> parameters = new LinkedMultiValueMap()<String,Object>();
//		parameters.add("quizVO", vo);
//		parameters.add("password", passwordObj);
		float score=restTemplate.postForObject(url2, new AttemtedQuizVO(new String[] {"java","java","java"}), Float.class);
		assertEquals(15.0,score );
	

	}

}
