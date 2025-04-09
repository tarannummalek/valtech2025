package com.valtech.training.loanserviceserver.webservices;

import javax.jws.WebService;

import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.vos.LoanVO;

@WebService
public interface LoanServiceWS {

	LoanVO getLoanVO(long id);

	LoanVO applyLoan(ApplyLoanVO applyLoanVO);

}