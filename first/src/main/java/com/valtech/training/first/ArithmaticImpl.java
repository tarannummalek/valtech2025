package com.valtech.training.first;

import org.springframework.stereotype.Component;

@Component
public class ArithmaticImpl implements Arithmatic {
	
	@Override
	public int add(int a, int b) {
		
		System.out.println("add a ="+a+"+"+b+ "=");
		return a+b;
	}
	@Override
	public int sub(int a, int b) {
		System.out.println("add a ="+a+"-"+b+ "=");

		return a-b;
	}
	@Override
	public int mul(int a, int b) {
		System.out.println("add a ="+a+"*"+b+ "=");

		return a*b;
	}
	@Override
	public int div(int a, int b) {
		System.out.println("add a ="+a+"/"+b+ "=");

		return a/b;
	}
	

}
