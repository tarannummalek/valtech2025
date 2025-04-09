package com.valtech.training.loanservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.webservices.LoanServiceWS;

@SpringBootTest
class LoanServiceApplicationTests {
	
	@Autowired
	private LoanServiceWS loanServiceWS;

	@Test
	void contextLoads() {
		loanServiceWS.applyLoan(new ApplyLoanVO("abc", 2323, 343434, 450, 40000));
		
		
	}
	

}
