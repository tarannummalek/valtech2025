package com.valtech.training.arithmatic;

public interface Operation {
	public static final Operation add=(a,b)->a+b;
	public static final Operation sub=(a,b)->a-b;
	public static final Operation mul=(a,b)->a*b;
	public static final Operation div=(a,b)->a/b;
	 int perform(int a, int b);

}
