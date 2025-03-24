package Assignmant1.services;

import java.util.List;
import java.util.Map;

import Assignmant1.entities.Employee;
import Assignmant1.entities.Employee.Gender;

public interface EmployeeService {

	Map<Gender, List<Employee>> getEmployeesByGenderForLevel(List<Employee> employees, int level);

	Map<Gender, List<Employee>> getEmployeesByGenderForName(List<Employee> employees, String keyWord);

	Map<Gender, List<Employee>> getEmployeesByGenderForGender(List<Employee> employees, Gender gender);

	Map<Gender, List<Employee>> getEmployeesByGenderForNameIgnoreCase(List<Employee> employees, String keyWord);

	Map<Gender, List<Employee>> getEmployeesByGenderForLevelAndGender(List<Employee> employees, int level,
			Gender gender);

	Double sumOfSalariesFromGenderWiseMap(Map<Gender, List<Employee>> genderViseLists);

	Map<Gender, Double> genderWiseMapOfsumOfSalariesByGenderWiseMap(Map<Gender, List<Employee>> genderViseEmplyeeList);

}