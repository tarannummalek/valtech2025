
package com.valtech.training.loanserviceserver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq")
	private long id;
	private LoanType type;
	private long value;
	private long assetValue; 
	private LoanStatus status;
	
	
	public Loan() {
	}
	public Loan(long id, LoanType type, long value, long assetValue, LoanStatus status) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
		this.assetValue = assetValue;
		this.status = status;
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
	public LoanStatus getStatus() {
		return status;
	}
	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	
	
	
	
	

}
