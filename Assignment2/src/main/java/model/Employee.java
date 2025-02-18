package model;

import java.util.Objects;

import dao.Gender;

public class Employee {

	
	private int salary;
	private int exp;
	private int level;
	private int age;
	String name;
	Gender gender;
	
	public Employee() {
	}
	
	public Employee(int salary, int exp, int level, int age, String name, Gender gender) {
		super();
		this.salary = salary;
		this.exp = exp;
		this.level = level;
		this.age = age;
		this.name = name;
		this.gender = gender;
	} 
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && exp == other.exp && gender == other.gender && level == other.level
				&& Objects.equals(name, other.name) && salary == other.salary;
	}
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", exp=" + exp + ", level=" + level + ", age=" + age + ", name=" + name
				+ ", gender=" + gender + "]";
	}

	
	
	
	
	
}
