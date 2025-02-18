package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void testToHashCode() { 
		Car car= new Car("Honda","City","2024","7","VX");
		int hash=car.hashCode();
      assertEquals(hash,car.hashCode())	;
      System.out.println(hash);
      assertNotEquals(new  Car("Honda","City","2024","7","VX").hashCode(),car.hashCode())	;
      System.out.println(car.hasCode());
	}
	@Test
	void testToString(){ 
		Car car= new Car("Honda","City","2024","7","VX");
		assertEquals("Honda City VX 2024 Version 7",car.toString());
	
	}
	
	@Test
	void testClone() throws CloneNotSupportedException {
		Car car=new Car("Honda","City","2024","7","VX");
		Car car1=(Car)car.clone();
		assertEquals(car,car1);
		//assertSame(car,car1);
	}
	


}
