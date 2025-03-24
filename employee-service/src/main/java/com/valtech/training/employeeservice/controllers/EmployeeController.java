package com.valtech.training.employeeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.employeeservice.services.EmployeeService;
import com.valtech.training.employeeservice.vos.EmployeeVO;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public EmployeeVO createEmployee(@RequestBody EmployeeVO employeeVO) {
		return employeeService.saveOrEmployee(employeeVO);
		
		
	}
	
	@GetMapping("/{id}")
	public EmployeeVO getEmployee(@PathVariable("id") long id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping("/")
	public List<EmployeeVO> getEmployeeList() {
		return employeeService.getAllEmployees();
	}
	
	
	

}
