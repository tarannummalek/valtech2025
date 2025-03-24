package Assignmant1.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import Assignmant1.entities.Employee;
import Assignmant1.entities.Employee.Gender;
import Assignmant1.services.EmployeeService;
import Assignmant1.services.EmployeeServiceImpl;


class EmployeeTest {
	
	private EmployeeService employeeService= new EmployeeServiceImpl();
	
	Employee employee1=	Employee.builder().salary(30000).id(7).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build();
	Employee employee2=	Employee.builder().salary(40000).id(6).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build();
	Employee employee3=Employee.builder().salary(40000).id(7).gender(Gender.FEMALE).age(52).name("lily").exp(20).level(3).build();
	Employee employee4=	Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(32).name("lily").exp(20).level(3).build();
	Employee employee5=Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("alen").exp(20).level(3).build();
	Employee employee6=Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("lily").exp(10).level(3).build();
	Employee employee7=Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("lily").exp(20).level(4).build();

	Employee employee8=	Employee.builder().salary(30000).id(7).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build();


	@Test
	void testHashCode() {
	
	assertNotEquals( employee1.hashCode(),employee2.hashCode());
	assertNotEquals( employee1.hashCode(),employee3.hashCode());
	assertNotEquals( employee1.hashCode(),employee4.hashCode());
	assertNotEquals( employee1.hashCode(),employee5.hashCode());
	assertNotEquals( employee1.hashCode(),employee6.hashCode());
	assertNotEquals( employee1.hashCode(),employee7.hashCode());
	
	}

	@Test
	void testEqualsObject() {
		assertTrue(employee1.equals(employee8));
		assertFalse(employee1.equals(employee2));

	}

	@Test
	void testCompareTo() {
		assertFalse(employee7.compareTo(employee1)>1);// by level
		assertFalse(employee5.compareTo(employee6)>1);// by exp
		assertFalse(employee2.compareTo(employee3)>1);// by gender
		assertFalse(employee5.compareTo(employee1)>1);// by salary
		
	}
	
	
	
	
	@Test
	void testUtils() {
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(Employee.builder().salary(30000).id(7).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build());
		employees.add(Employee.builder().salary(40000).id(6).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build());
		employees.add(Employee.builder().salary(40000).id(7).gender(Gender.FEMALE).age(52).name("lily").exp(20).level(3).build());
		employees.add(Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(32).name("lily").exp(20).level(3).build());
		employees.add(Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("alen").exp(20).level(3).build());
		employees.add(Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("lily").exp(10).level(3).build());
		employees.add(Employee.builder().salary(40000).id(7).gender(Gender.MALE).age(52).name("lily").exp(20).level(4).build());
		
		//Emps by level
		Map<Gender, List<Employee>> employeesByGenderForLevel=employeeService.getEmployeesByGenderForLevel(employees,3);
		
		//Emps by Gender
		Map<Gender, List<Employee>> employeesByGenderForGender=employeeService.getEmployeesByGenderForGender(employees, Gender.FEMALE);
	
		//Emps by contains name
		Map<Gender, List<Employee>> employeesByGenderForName=employeeService.getEmployeesByGenderForName(employees, "l");
		
		//Emps by name Ignore case
		Map<Gender, List<Employee>> employeesByGenderForNameIgnoreCase=employeeService.getEmployeesByGenderForNameIgnoreCase(employees, "L");
		
		//Emps by gender and level
		Map<Gender, List<Employee>> employeesByGenderForLevelAndGender=employeeService.getEmployeesByGenderForLevelAndGender(employees, 3, Gender.MALE);

		
		assertEquals(1, employeeService.getEmployeesByGenderForGender(employees, Gender.FEMALE).get(Gender.FEMALE).size());
		assertEquals(1, employeeService.getEmployeesByGenderForLevel(employees, 3).get(Gender.FEMALE).size());
		assertEquals(1, employeeService.getEmployeesByGenderForLevelAndGender(employees, 3, Gender.FEMALE).get(Gender.FEMALE).size());
		//assertEquals(1, employeeService.getEmployeesByGenderForName(employees, "al").get(Gender.FEMALE).size());
		//assertEquals(3, employeeService.getEmployeesByGenderForNameIgnoreCase(employees, "AL").get(Gender.MALE).size());
		
		assertEquals(190000,employeeService.genderWiseMapOfsumOfSalariesByGenderWiseMap(employeesByGenderForLevel).get(Gender.MALE));
		//assertEquals(110000,sumOfSalariesByGenderLevel(genderViseEmplyeeMap).get(Gender.MALE));
		assertEquals(230000,employeeService.genderWiseMapOfsumOfSalariesByGenderWiseMap(employeesByGenderForName).get(Gender.MALE));
     	//assertEquals(30000,sumOfSalariesByGenderLevel(nameIgnoreCaseViseEmplyeeMap).get(Gender.FEMALE));
		
     	//assertEquals(30000,sumOfSalariesByGenderLevel(levelAndGenderViseEmplyeeMap).get(Gender.FEMALE));
		//assertEquals(30000,sumOfSalariesByGenderLevel(levelAndGenderViseEmplyeeMap).get(Gender.MALE));

		
		//assertEquals(190000, employeeService.genderWiseMapOfsumOfSalariesByGenderWiseMap(employeesByGenderForLevelAndGender).get(Gender.MALE));
		
		//assertEquals(null, employeeService.genderWiseMapOfsumOfSalariesByGenderWiseMap(employeesByGenderForLevelAndGender));

	}
}