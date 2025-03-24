package com.valtech.training.loanserviceserver.services;

import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.vos.LoanVO;

public interface LoanService {

	LoanVO applyLoan(ApplyLoanVO vo);

	LoanVO getlLoanVO(long id);

}