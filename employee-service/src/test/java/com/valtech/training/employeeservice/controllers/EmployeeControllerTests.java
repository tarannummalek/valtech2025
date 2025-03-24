package com.valtech.training.employeeservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employeeservice.vos.EmployeeVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTests {

	@LocalServerPort 
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	void addEmployees() {
		
		List emps=restTemplate.getForObject("http://localhost:"+port+"/api/v1/employees/",List.class);
		
		if(emps.size()==0) {
			System.out.println("Adding employees to DB...");
			EmployeeVO manager=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",new EmployeeVO(0, "abc",78787878, "abc@gmail.com", 0), EmployeeVO.class);
			EmployeeVO manager1=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",new EmployeeVO(0, "def",78845, "ac@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp1=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",new EmployeeVO(0, "pqr",7878756, "bc@gmail.com", manager1.id()), EmployeeVO.class);
			EmployeeVO emp2=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",new EmployeeVO(0, "xyz",78786, "b@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp3=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/",new EmployeeVO(0, "xz",78786, "rtb@gmail.com", manager1.id()), EmployeeVO.class);

		}
	}

}
