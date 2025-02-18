package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestingSecond {

	@Test
	public void isValidNegativeSide() {
	    Triangle t = new Triangle();
	    boolean actual = t.isValid();

	    assertEquals(actual, true);
	}
}
