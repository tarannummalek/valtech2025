package com.valtech.training.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class SimpleInterastImpl implements SimpleInterast {
	
	private Arithmatic arithmatic;
	
	
	
	
	public SimpleInterastImpl(Arithmatic arithmatic) {
		super();
		this.arithmatic = arithmatic;
	}
	public int compute(int prin, int time , int rate ) {
		return arithmatic.div(arithmatic.mul(prin*time, rate),100);
	}
	public void setArithmatic(Arithmatic arithmatic) {
		this.arithmatic = arithmatic;
	}

}
