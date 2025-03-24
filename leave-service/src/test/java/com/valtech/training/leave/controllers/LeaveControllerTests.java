package com.valtech.training.leave.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.common.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveVO;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveControllerTests {
	
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void applyAndApprove() {
		String url="http://localhost:"+port+"/api/v1/leaves/";
		LeaveVO vo=restTemplate.postForObject(url+"apply", new LeaveVO(0, "08-05-2033","09-05-2033", LeaveType.CASUAL.name(), LeaveStatus.APPLIED.name(), "Going to native", "", 7), LeaveVO.class);

		assertTrue(vo.id()!=0);
		assertEquals(vo.status(), LeaveStatus.APPLIED.name());
		ApproveLeaveVO avo=new ApproveLeaveVO(vo.id(), "leave approved", 6);
		vo=restTemplate.postForObject(url+"approve", avo, LeaveVO.class);
		assertEquals(vo.status(), LeaveStatus.APPROVED.name());
		
	}

	@Test
	void test() {
		String url="http://localhost:"+port+"/api/v1/leaves/";
		List leaves=restTemplate.getForObject(url, List.class);
		
			restTemplate.postForObject(url, new LeaveVO(0, "08-05-2033","09-05-2033", LeaveType.CASUAL.name(), LeaveStatus.APPLIED.name(), "Going to native", "", 7), LeaveVO.class);
			restTemplate.postForObject(url, new LeaveVO(0, "08-05-2033","09-05-2033", LeaveType.SICK.name(), LeaveStatus.APPLIED.name(), "flue", "", 7), LeaveVO.class);
			restTemplate.postForObject(url, new LeaveVO(0, "08-05-2033","09-05-2033", LeaveType.SICK.name(), LeaveStatus.APPLIED.name(), "flue", "", 7), LeaveVO.class);


		
	}

}
