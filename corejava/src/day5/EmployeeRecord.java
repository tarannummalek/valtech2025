package day5;

import Assignmant1.Employee.Gender;

public record EmployeeRecord(int id, String name , int age , Gender gender , float salary, int experience, int level) {
	
	public EmployeeRecord() {
		this(0,"",0,Gender.FEMALE,0,0,0);
	}
	
	public int computeBonus() {
		return experience*100+level*1000;
	}

}
