package com.valtech.training.loanserviceserver.webservices;



import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loanserviceserver.services.LoanService;
import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.vos.LoanVO;



@WebService(endpointInterface = "com.valtech.training.loanserviceserver.webservices.LoanServiceWS",name="LoanService",portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {
	@Autowired
	private LoanService loanService;
	
	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService=loanService;
	}
	
	@Override
	public LoanVO getLoanVO(long id) {
		return loanService.getlLoanVO(id);
	}
	
	@Override
	public String applyLoan(ApplyLoanVO applyLoanVO) {
		return loanService.applyLoan(applyLoanVO);
	}
	
	

}
