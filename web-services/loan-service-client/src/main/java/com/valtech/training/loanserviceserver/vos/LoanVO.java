package com.valtech.training.loanserviceserver.vos;

import com.valtech.training.loanserviceserver.entities.Loan;
import com.valtech.training.loanserviceserver.entities.LoanStatus;
import com.valtech.training.loanserviceserver.entities.LoanType;

public record LoanVO (long id,LoanType type,long value,long assetValue,LoanStatus leaveStatus){
	
	public static LoanVO from(Loan loan) {
		return new LoanVO(loan.getId(), loan.getType(),loan.getValue(),loan.getAssetValue(), loan.getStatus());
		
	}
	public Loan to(LoanVO loanVO) {
		return new Loan(id, type, value, assetValue, leaveStatus);
	}
	

}
