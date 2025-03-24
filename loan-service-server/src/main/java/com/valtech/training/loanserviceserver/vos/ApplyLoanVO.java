package com.valtech.training.loanserviceserver.vos;

public class ApplyLoanVO {
	
private String customerName;
private long pan;
private long aadhar;
private int cibil;
private long income;
public ApplyLoanVO() {
	super();
	// TODO Auto-generated constructor stub
}
public ApplyLoanVO(String customerName, long pan, long aadhar, int cibil, long income) {
	super();
	this.customerName = customerName;
	this.pan = pan;
	this.aadhar = aadhar;
	this.cibil = cibil;
	this.income = income;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public long getPan() {
	return pan;
}
public void setPan(long pan) {
	this.pan = pan;
}
public long getAadhar() {
	return aadhar;
}
public void setAadhar(long aadhar) {
	this.aadhar = aadhar;
}
public int getCibil() {
	return cibil;
}
public void setCibil(int cibil) {
	this.cibil = cibil;
}
public long getIncome() {
	return income;
}
public void setIncome(long income) {
	this.income = income;
}



}
