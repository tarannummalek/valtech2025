package Assignmant1.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Assignmant1.entities.Employee;
import Assignmant1.entities.Employee.Gender;

public class EmployeeServiceImpl implements EmployeeService {
	@Override
	public Map<Gender,List<Employee>> getEmployeesByGenderForLevel(List<Employee> employees,int level){
		return employees.stream().filter(e->e.getLevel()==level)
				.sorted(Employee::compareTo)
				.collect(Collectors.groupingBy(Employee::getGender));
	}
	
	@Override
	public Map<Gender,List<Employee>> getEmployeesByGenderForName(List<Employee> employees,String keyWord){
		return employees.stream().filter(e->e.getName().contains(keyWord))
				.sorted(Employee::compareTo)
				.collect(Collectors.groupingBy(Employee::getGender));
	}
	
	@Override
	public Map<Gender,List<Employee>> getEmployeesByGenderForGender(List<Employee> employees,Gender gender){
		return employees.stream().filter(e->e.getGender()==gender)
				.sorted(Employee::compareTo)
				.collect(Collectors.groupingBy(Employee::getGender));
	}
	@Override
	public Map<Gender,List<Employee>> getEmployeesByGenderForNameIgnoreCase(List<Employee> employees,String keyWord){
		return employees.stream().filter(e->e.getName().equalsIgnoreCase(keyWord))
				.sorted(Employee::compareTo)
				.collect(Collectors.groupingBy(Employee::getGender));
	}
	@Override
	public Map<Gender,List<Employee>> getEmployeesByGenderForLevelAndGender(List<Employee> employees,int level,Gender gender){
		return employees.stream().filter(e->e.getLevel()==level&&e.getGender()==gender)
				.sorted(Employee::compareTo)
				.collect(Collectors.groupingBy(Employee::getGender));
	}
	
	@Override
	public Double sumOfSalariesFromGenderWiseMap(Map<Gender, List<Employee>> genderViseLists) {
		return genderViseLists.values().stream().flatMap(l->l.stream())
				.mapToDouble(Employee::getSalary).sum();
	}
	
	@Override
	public Map<Gender,Double> genderWiseMapOfsumOfSalariesByGenderWiseMap(Map<Gender, List<Employee>> genderViseEmplyeeList){
		return genderViseEmplyeeList.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().mapToDouble(Employee::getSalary).sum()));
	}

}
