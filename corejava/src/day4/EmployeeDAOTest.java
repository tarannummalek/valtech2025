package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignmant1.Employee;
import Assignmant1.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		
		EmployeeDAO dao=new EmployeeDAOImpl();
		//dao.save(new Employee(3,"working",23,20000,1,5,Gender.FEMALE));
		Employee e=new Employee(2,"DE",23,20000,1,5,Gender.FEMALE);
		dao.update(e);
		e=dao.get(2);
		assertEquals("DE",e.getName());
		assertEquals(2,e.getId());
		assertEquals(23,e.getAge());
		assertEquals(20000,e.getSalary());
		assertEquals(Gender.FEMALE,e.getGender());
		assertEquals(5,e.getExp());
		assertEquals(1,e.getLevel());
		
		
		assertTrue(dao.getAll().size()>1);
		//assertEquals(1,delete(2));
		dao.delete(2);
	}
	
	

}
