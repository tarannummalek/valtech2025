package Assignmant1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import Assignmant1.Employee.EmployeeBuilder;
import Assignmant1.Employee.Gender;
import day2.Car;
import day2.Car.CarBuilder;

class EmployeeTest {
	
	Employee employee=Employee.builder().age(30).exp(5).level(3).id(7).gender(Gender.MALE).salary(40000).name("james").build();
	Employee employee2=Employee.builder().age(30).exp(5).level(3).id(7).gender(Gender.MALE).salary(40000).name("james").build();
	Employee employee1=Employee.builder().age(40).exp(5).level(3).id(7).salary(40000).gender(Gender.MALE).name("james").build();
	//employee.setAge(12);

	@Test
	void testHashCode() {

	assertEquals( employee.hashCode(),employee2.hashCode());
	assertNotEquals( employee1.hashCode(),employee2.hashCode());


	}

	@Test
	void testEqualsObject() {
		assertEquals( false,employee.equals(employee1));
		assertNotEquals( false,employee.equals(employee2));


	}

	@Test
	void testCompareTo() {
		assertEquals(false,employee.compareTo(employee1)>1);
		assertEquals(false,employee.compareTo(employee1)>1);
		assertEquals(false,employee.compareTo(employee1)>1);
	}
	
	
	
	@Test
	void testUtils() {
		List<Employee> employee=new ArrayList<Employee>();
		employee.add(Employee.builder().salary(30000).id(0).gender(Gender.FEMALE).age(42).name("alex").exp(10).level(3).build());
		employee.add(Employee.builder().salary(40000).id(1).gender(Gender.OTHER).age(22).name("alexander").exp(1).level(2).build());
		employee.add(Employee.builder().salary(70000).id(2).gender(Gender.MALE).age(32).name("alen").exp(8).level(2).build());
		employee.add(Employee.builder().salary(40000).id(3).gender(Gender.MALE).age(52).name("lily").exp(20).level(3).build());
		
		Map<Gender, List<Employee>> levelViseEmplyeeMap=employee.stream().filter(e->e.getLevel()==3).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
		//demo
		//Map<Gender,List<Employee>> level=employee.stream().filter(a->a.getSalary()==30000).collect(Collectors.groupingBy(Employee::getGender));
		
		//Emp by Gender
		Map<Gender, List<Employee>> genderViseEmplyeeMap=employee.stream().filter(e->e.getGender()==Gender.MALE).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	
		
		//Emp by contains name
		Map<Gender, List<Employee>> nameViseEmplyeeMap=employee.stream().filter(e->e.getName().contains("ale")).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
		
		//Emp by name Ignore case
		Map<Gender, List<Employee>> nameIgnoreCaseViseEmplyeeMap=employee.stream().filter(e->e.getName().equalsIgnoreCase("ALEX")).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
		
		//Emp by gender and level
		Map<Gender, List<Employee>> levelAndGenderViseEmplyeeMap=employee.stream().filter(e->e.getLevel()==3&&e.getGender()==Gender.FEMALE).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));

		//Map<Gender, List<Employee>> levelViseMap=levelViseEmployeeMap(employee,3);
		
		//sum(employee);
		//Emp by level
		
		System.out.println(levelViseEmplyeeMap);
		System.out.println(genderViseEmplyeeMap);
		System.out.println(nameViseEmplyeeMap);
		System.out.println(nameIgnoreCaseViseEmplyeeMap);
		System.out.println(levelAndGenderViseEmplyeeMap);
		
		
//		aseertEquals
		
		
		//converToMap(genderViseEmplyeeList);
		//sumOfSalary(genderViseEmplyeeList);
		//sumOfSalary(genderViseEmplyeeList1);
		//System.out.println(genderViseEmplyeeList);
		//System.out.println(salariesByGender(employee));
		
	    double sum=employee.stream().filter(e->e.getLevel()==3).mapToDouble(Employee::getSalary).sum();
	    System.out.println("sum ::"+ sum);
		
	   // assertEquals(30000,totalSum(levelAndGenderViseEmplyeeMap(employee,3)));
		//Collections.sort(null);
		//System.out.println(levelViseEmplyeeMap);
		
		
		assertEquals(40000,salariesByGender(levelViseEmplyeeMap).get(Gender.MALE));
		assertEquals(110000,salariesByGender(genderViseEmplyeeMap).get(Gender.MALE));
		assertEquals(70000,salariesByGender(nameViseEmplyeeMap).get(Gender.MALE));
     	assertEquals(30000,salariesByGender(nameIgnoreCaseViseEmplyeeMap).get(Gender.FEMALE));
		assertEquals(30000,salariesByGender(levelAndGenderViseEmplyeeMap).get(Gender.FEMALE));
		
		
	    
	    
//	    System.out.println(sumOfSalaries(salariesByGender(levelAndGenderViseEmplyeeMap)));
//		String s=new String("q");
//		String s1=new String("q");
//		System.out.println(s1.equals(s1));
//		
//		System.out.println(totalSum(levelViseEmplyeeMap));
		
		
		
		
		//Map of Gender with sum of salaries
		
	}
	
//	int sumOfSalary(Map<Gender, List<Employee>> empList) {
//		double totalSalary=empList.stream().mapToDouble(Employee::getSalary).sum();
//		System.out.println(totalSalary);
//		//genderViseEmplyeeList.values().stream().
//		return 0;
//	}
	
//	Map<Gender, List<Employee>> converToMap(List<Employee> empList){
//		return empList.stream().collect(Collectors.groupingBy(Employee::getGender));
//				}
	Map<Gender,Double> salariesByGender(Map<Gender, List<Employee>> genderViseEmplyeeList){
		return genderViseEmplyeeList.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().mapToDouble(Employee::getSalary).sum()));
	}
	
	Double totalSum(Map<Gender, List<Employee>> genderViseLists) {
		return genderViseLists.values().stream().flatMap(l->l.stream()).mapToDouble(Employee::getSalary).sum();
	}
	
	
//	Double sum(List<Employee> genderViseEmplyeeList){
//		return genderViseEmplyeeList.stream().map(e->e.getSalary()).reduce(0.0,(a,b)->(a+b));
//	}
	
	Double sumOfSalaries(Map<Gender,Double> genderWiseSumMap) {
		
		return genderWiseSumMap.values().stream().mapToDouble(Double ::valueOf).sum();
	}
	
	
	

	

	
	
	@Test
	void testSum() {
	
		
		
		
		
		
	}
	@Test
	void testEmployee() {
		
		
		
	}

	
}