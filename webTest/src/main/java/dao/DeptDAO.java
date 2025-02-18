package dao;

import java.util.List;
import java.util.Set;

public interface DeptDAO {

	Dept getDept(int id);
	void update(Dept d);
	List<Dept> getAll();
	void save(Dept d);
	
	Dept first();
	Dept last();
	Dept prev(int id);
	Dept next(int id);
	List<Employee> getEmployeesByDepartment(int dept_id);
	
}
