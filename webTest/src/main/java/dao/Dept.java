package dao;

import java.util.List;

import dao.Employee.EmployeeBuilder;
import dao.Employee.Gender;

public class Dept {

	private int id;
	private String name;
	private String location;
	private List<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Dept(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Dept() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	public static DeptBuilder builder() {
		return new DeptBuilder(new Dept());
	}
	
	
	// builder pattern
	public static class DeptBuilder{
		
		Dept dept;

		public DeptBuilder(Dept dept) {
			super();
			this.dept=dept;
		}		
		public Dept build() {
			return dept;
		}
		
		public DeptBuilder id(int id) {
			dept.setId(id);
			return this;
		}
		
		public DeptBuilder name(String name) {
			dept.setName(name);
			return this;
		}
		public DeptBuilder location(String name) {
			dept.setLocation(name);
			return this;
		}
				
	}
	
	
	
}
