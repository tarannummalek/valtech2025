package dao;

import java.util.Set;

import model.Employee;

public interface EmployeeDAO {

void save(Employee employee);
void update(Employee employee);
Employee get(int id);
Set<Employee> getAll();
void delete(int id);
	
}
