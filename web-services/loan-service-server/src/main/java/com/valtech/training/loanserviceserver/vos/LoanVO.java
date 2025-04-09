package com.valtech.training.loanserviceserver.vos;

import com.valtech.training.loanserviceserver.entities.Loan;
import com.valtech.training.loanserviceserver.entities.LoanStatus;
import com.valtech.training.loanserviceserver.entities.LoanType;

public class LoanVO {
	
private long id;
private LoanType type;
private long value;
private long assetValue;
private LoanStatus leaveStatus;


	
	public LoanVO() {
	super();
	// TODO Auto-generated constructor stub
}
	
	
	public LoanVO(long id, LoanType type, long value, long assetValue, LoanStatus leaveStatus) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
		this.assetValue = assetValue;
		this.leaveStatus = leaveStatus;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LoanType getType() {
		return type;
	}


	public void setType(LoanType type) {
		this.type = type;
	}


	public long getValue() {
		return value;
	}


	public void setValue(long value) {
		this.value = value;
	}


	public long getAssetValue() {
		return assetValue;
	}


	public void setAssetValue(long assetValue) {
		this.assetValue = assetValue;
	}


	public LoanStatus getLeaveStatus() {
		return leaveStatus;
	}


	public void setLeaveStatus(LoanStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}


	public static LoanVO from(Loan loan) {
		return new LoanVO(loan.getId(), loan.getType(),loan.getValue(),loan.getAssetValue(), loan.getStatus());
		
	}
	public Loan to(LoanVO loanVO) {
		return new Loan(id, type, value, assetValue, leaveStatus);
	}
	

}
