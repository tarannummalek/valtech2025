package day2;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmaticImplTest2 {
	ArithmaticImpl a=new ArithmaticImpl();

	@Test
	void testAdd() {
		assertEquals(3.0,a.add(1.0,2.0));
	}

	@Test
	void testSub() {
		assertEquals(3.0,a.sub(1.0,2.0));
	}

	@Test
	void testMul() {
		assertEquals(3.0,a.mul(1.0,2.0));
	}

	@Test
	void testDiv() {
		assertEquals(3.0,a.div(1.0,2.0));
	}

	
	@Test
	void testDivWithIntDivIsZero() {
	try {
		example(new ArithmaticImpl());
		fail("Exception was excepted!!!");
		
	}catch(Exception e){
		
	}
	}
	
	private static void example(Arithmatic a) {
		a.add(0, 2);
		a.div(4, 0);
		a.mul(5, 0);
		a.sub(0, 9);
	}
	
	@Test
	void testDivWithIntDivIsZero1() {
	try {
		example(new ArithmaticImpl());
		fail("Exception was excepted!!!");
		
	}catch(Exception e){
		
	}
	}
	
	
	
}
