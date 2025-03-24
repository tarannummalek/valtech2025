package com.valtech.training.leave.leave.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.enities.LeaveMaster;
import com.valtech.training.leave.vos.LeaveMasterVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LeaveMasterControllerTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private Integer port;
	
	
	
	@Test
	void createLeaveMastersTest() {
		String baseUrl="http://localhost:"+port+"/api/v1/leavemasters/";
		
		List leaveMasters=restTemplate.getForObject(baseUrl, List.class);
		
		if(leaveMasters.size()==0) {
			restTemplate.postForObject(baseUrl, new LeaveMaster(4, 5, 5, 6), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, new LeaveMaster(4, 4, 4, 7), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, new LeaveMaster(4, 4, 4, 8), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, new LeaveMaster(3, 3, 3, 9), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl, new LeaveMaster(3, 3, 3, 10), LeaveMasterVO.class);

		
		}
	}
}
