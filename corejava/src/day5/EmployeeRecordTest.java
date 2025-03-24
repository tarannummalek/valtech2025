package day5;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignmant1.entities.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er=new EmployeeRecord(1,"abc",23, Gender.FEMALE,12000,5,2);
		System.out.println(er);
		assertEquals(1,er.id());
		assertEquals("abc",er.name());
		assertEquals(23,er.age());
		assertEquals(Gender.FEMALE,er.gender());
		EmployeeRecord er1=new EmployeeRecord(1,"abc",23, Gender.FEMALE,12000,5,2);
		assertEquals(er.hashCode(),er1.hashCode());
		EmployeeRecord er2=new EmployeeRecord(1,"abc1",23, Gender.FEMALE,12000,5,2);
		assertFalse(er1.hashCode()==er2.hashCode());
		assertNotEquals(er,er2);
		assertEquals(2500,er.computeBonus());
		
	}

	
	
}
