package com.valtech.training.employeeservice.vos;

import com.valtech.training.employeeservice.entities.Employee;

public record EmployeeVO (long id, String name,long mobile,String email,long managerId) {
	
public static EmployeeVO from (Employee e) {
	long manId=e.getManager()==null?0:e.getManager().getId();
	return new EmployeeVO(e.getId(),e.getName(),e.getMobile(),e.getEmail(),manId);
}


public Employee to(Employee manager) {
	
	Employee e1=new Employee(id,name,mobile,email);
	e1.setManager(manager);
	return e1;
	
	
}
}
