package homeworktask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void testToString() {
		Datetime dateTime=new Datetime("03-03-25");
		assertEquals("3-3-25 IST 0:0:0", dateTime.toString());
		
	}

}
