package com.valtech.training.quizservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valtech.training.quizservice.vo.QuestionVO;

@Component
public class QuestionClient {
	
	public List getQuestions(String topic) {
		RestTemplate temp=new RestTemplate();
		String url="http://localhost:9040/questions/q/"+topic;		
		ObjectMapper mapper = new ObjectMapper();
        JsonNode questions = temp.getForObject(url, JsonNode.class);
        List<QuestionVO> questionList = mapper.convertValue(questions, new TypeReference<List<QuestionVO>>() {});
        List<QuestionVO> result = new ArrayList<>();
        for(QuestionVO s : questionList){
                result.add(s);
            
        }
        return result;
	}
	public QuestionVO getQuestion(long id) {
		RestTemplate temp=new RestTemplate();
		String url="http://localhost:9040/questions/"+id;		
		ObjectMapper mapper = new ObjectMapper();
		return null;
		
	}

}
