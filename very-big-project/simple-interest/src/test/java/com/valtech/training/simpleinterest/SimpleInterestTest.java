package com.valtech.training.simpleinterest;

import junit.framework.TestCase;

public class SimpleInterestTest extends TestCase {
	public void testSimpleInterest() {
		SimpleInterest si=new SimpleInterest();
		assertEquals(500, si.compute(5, 10, 10));
		
	}

}
