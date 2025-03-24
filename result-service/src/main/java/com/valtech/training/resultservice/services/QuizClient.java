package com.valtech.training.resultservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valtech.training.resultservice.vos.QuizVO;

@Component
public class QuizClient {
	
	public QuizVO getQuiz(long quizId) {
		RestTemplate temp=new RestTemplate();
		String url="http://localhost:9050/quizes/"+quizId;		
		ObjectMapper mapper = new ObjectMapper();
        JsonNode quiz = temp.getForObject(url, JsonNode.class);
        QuizVO quiz1 = mapper.convertValue(quiz, new TypeReference<QuizVO>() {});
        return quiz1;
	}

}
