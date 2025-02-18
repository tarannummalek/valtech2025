package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSquareNow() {
		
		Square square=(x) -> x*x;
		
		Square square2=new Square() {
			

			@Override
			public double squareNow(double x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		
		assertEquals(0,square.squareNow(0));
		assertEquals(1,square.squareNow(-1));	
		assertEquals(4,square.squareNow(-2));
		assertEquals(1,square.squareNow(1));
		assertEquals(0,square.squareNow(0));
	}

}
