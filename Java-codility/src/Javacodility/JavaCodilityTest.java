package Javacodility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JavaCodilityTest {

	@Test
	void testToString() {
		Datetime dateTime=new Datetime("03-03-25");
		assertEquals("3-3-25 IST 0:0:0", dateTime.toString());
		
	}



	    @Test
	    public void testDaysBetween() {
	        Datetime date1 = new Datetime("01-01-2020");
	        Datetime date2 = new Datetime("01-01-2025");
	        int expectedDays = 1826;
	        int actualDays = date1.getDaysBetween(date2);
	        assertEquals(expectedDays, actualDays);
	    }

	    @Test
	    public void testLeapYear() {
	        Datetime date1 = new Datetime("28-02-2020");  // Leap year date
	        Datetime date2 = new Datetime("28-02-2021");  // Non-leap year date
	        int expectedDays = 366;
	        int actualDays = date1.getDaysBetween(date2);
	        assertEquals(expectedDays, actualDays);
	    }

	    @Test
	    public void testSameDay() {
	        Datetime date1 = new Datetime("15-06-2022");
	        Datetime date2 = new Datetime("15-06-2022");
	        int expectedDays = 0;
	        int actualDays = date1.getDaysBetween(date2);
	        assertEquals(expectedDays, actualDays);
	    }

	    @Test
	    public void testDaysBetweenWithDifferentYears() {
	        Datetime date1 = new Datetime("01-01-2018");
	        Datetime date2 = new Datetime("01-01-2022");
	        int expectedDays = 1461;
	        int actualDays = date1.getDaysBetween(date2);
	        assertEquals(expectedDays, actualDays);
	    }


	        @Test
	        public void testSortMobileNumbers() {
	            long[] mobileNos = {123123, 987654, 111222, 555555, 12312345, 222333, 111111};
	            long[] expectedSortedNumbers = {111111, 555555, 111222, 123123, 222333, 987654, 12312345};//the first and second halves are the same
	            long[] sortedNumbers = PhoneNumberRemembering.sortMobileNumbers(mobileNos);
	            assertEquals(expectedSortedNumbers, sortedNumbers);
	        }

	        @Test
	        public void testGetEaseOfRememberingScore() {
	            long number1 = 555555;
	            int expectedScore1 = 3;  //all digits are the same
	            int actualScore1 = PhoneNumberRemembering.getEaseOfRememberingScore(number1);
	            assertEquals(expectedScore1, actualScore1);

	        }


	            @Test
	            public void testSortByVowelCount() {
	                String[] sentences = { "sdsds vgg", "aeiou", "fdfdffdf yuyuuu" };
	                String[] expectedSortedSentences = { "sdsds vgg", "fdfdffdf yuyuuu", "aeiou" };
	                String[] sortedSentences = JavaCodility.sortByVowelCount(sentences);
	                assertEquals(expectedSortedSentences, sortedSentences);
	            }

	            @Test
	            public void testRatePassword() {
	                JavaCodility codility = new JavaCodility();

	                String password1 = "Abc123!@#";
	                String expectedRating1 = "Strong";
	                assertEquals(expectedRating1, codility.ratePassword(password1));

	                String password2 = "Abc123";
	                String expectedRating2 = "Medium";
	                assertEquals(expectedRating2, codility.ratePassword(password2));

	                String password3 = "abc";
	                String expectedRating3 = "Weak";
	                assertEquals(expectedRating3, codility.ratePassword(password3));

	                String password4 = "abc1!";
	                String expectedRating4 = "Password length is short";
	                assertEquals(expectedRating4, codility.ratePassword(password4));
	            }
	        


}
