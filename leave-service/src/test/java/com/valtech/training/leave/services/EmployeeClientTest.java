package com.valtech.training.leave.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeClientTest {

	@Autowired
	EmployeeClient employeeClient;
	
	@Test
	void test() {
		
		assertEquals(6, employeeClient.getManager(7));
		assertEquals(7, employeeClient.getManager(8));	
		
	}

}
