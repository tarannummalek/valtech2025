package com.valtech.training.loanserviceserver.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loanserviceserver.services.LoanService;
import com.valtech.training.loanserviceserver.vos.ApplyLoanVO;
import com.valtech.training.loanserviceserver.vos.LoanVO;

@WebService(endpointInterface = "com.valtech.training.loanserviceserver.webservices.LoanServiceWS", name = "LoanService", portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {

    private final LoanService loanService;

    @Autowired
    public LoanServiceWSImpl(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public LoanVO getLoanVO(long id) {
        return loanService.getLoanVO(id);
    }

    @Override
    public LoanVO applyLoan(ApplyLoanVO applyLoanVO) {
        return loanService.applyLoan(applyLoanVO); 
    }
}
