package com.valtech.training.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.employeeservice.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	

}
