package com.valtech.training.employeeservice.services;

import java.util.List;

import com.valtech.training.employeeservice.entities.Employee;
import com.valtech.training.employeeservice.vos.EmployeeVO;

public interface EmployeeService {

	EmployeeVO saveOrEmployee(EmployeeVO e);

	EmployeeVO getEmployee(long id);

	List<EmployeeVO> getAllEmployees();

}