package com.valtech.training.simpleinterest;

 
import com.valtech.training.arithmatic.Operation;

public class SimpleInterest {
	
	public int compute (int prin,int rate,int time) {
		return Operation.mul.perform(prin *rate,time);
		
	}

}
