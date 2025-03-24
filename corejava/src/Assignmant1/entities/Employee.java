package Assignmant1.entities;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import Assignmant1.entities.Employee.EmployeeBuilder;
import Assignmant1.entities.Employee.Gender;

public class Employee implements Comparable<Employee> {

	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int exp;
	public Gender gender;

	public Employee() {

	}

	public Employee(long id, String name, int age, float salary, int level, int exp, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.exp = exp;
		this.gender = gender;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public enum Gender implements Comparable<Gender> {

		FEMALE, MALE, OTHER

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", level=" + level
				+ ", exp=" + exp + "]";
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
		return level == other.level && age == other.age && exp == other.exp && id == other.id
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}

	@Override
	public int compareTo(Employee other) {
		if (other == this || this.equals(other))
			return 0;
		else if (this.level != level)
			return other.level - this.level;
		else if (this.exp != exp)
			return other.exp - this.exp;
		// else if(this.gender.compareTo(other.getGender())>1);
		else if (this.gender.compareTo(other.gender) > 0)
			return -1;
		return Double.compare(other.salary, this.salary);

		// return this.salary==other.salary;

	}

	// to call builder

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}

	// builder pattern
	public static class EmployeeBuilder {

		Employee employee;

		public EmployeeBuilder(Employee employee) {
			super();
			this.employee = employee;
		}

		public Employee build() {
			return employee;
		}

		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}

		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}

		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}

		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}

		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		}

		public EmployeeBuilder exp(int exp) {
			employee.setExp(exp);
			return this;
		}

		public EmployeeBuilder gender(Gender gender) {
			employee.setGender(gender);
			return this;
		}

	}

}
