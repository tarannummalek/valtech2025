package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {

	ServletContext sc;
	
	static {
		
	
		
	}
	public DeptDAOImpl(ServletContext sc) {
		this.sc=sc;
	}
	
	private Connection getConnection(ServletContext sc) throws SQLException{

		
		String url=(String) sc.getAttribute("url");
		String username=(String) sc.getAttribute("username");
		String password=(String) sc.getAttribute("password");
		
		return DriverManager.getConnection(url,username,password);
	}
	
	private void setValuesToPrepareStatements(Dept d, PreparedStatement ps) throws SQLException {
		ps.setString(2, d.getName());
		ps.setString(3, d.getLocation());
		ps.setInt(1, d.getId());
		
	}
	
	
	public Dept first() {
		DeptDAOImpl d=new DeptDAOImpl(this.sc);
		List<Dept> empList=d.getAll();
		int id= empList.stream().mapToInt(Dept::getId).min().orElseThrow();
		return d.getDept(id);
				}
	public Dept prev(int id) {
		DeptDAOImpl d=new DeptDAOImpl(this.sc);
		List<Dept> empList=d.getAll();
		if (id==d.first().getId()) {
			return d.getDept(id);
		}
		return d.getDept(id-1);
	}
	
	public Dept next(int id)
	{
		DeptDAOImpl d=new DeptDAOImpl(this.sc);
		if(id==d.last().getId()) {
			return d.getDept(id);
		}
		return d.getDept(id+1);
		
	}
	
	public void save(Dept dept) {
		try(Connection conn = getConnection(this.sc)){
			System.out.println(".................");
			PreparedStatement ps=conn.prepareStatement("INSERT INTO DEPARTMENT (ID,NAME,LOCATION) VALUES(?,?,?)");
			setValuesToPrepareStatements(dept, ps);
			
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows inserted: "+rowsAffected);
		}catch(Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}
	
	public Dept getDept(int id) {
		try(Connection conn = getConnection(this.sc)){
			System.out.println(".................");
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,LOCATION FROM DEPARTMENT WHERE ID=?");
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				Dept d=populateDepartment(rs);
				return d;
			}else{
				throw new RuntimeException("No emp with id"+id);
			}
			
			}catch(Exception e) {
				
				
			}
			return null;
			
		
	}

private Dept populateDepartment(ResultSet rs) {
	try {
		Dept d=Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
				//Employee.builder().name(rs.getString(2)).age(rs.getInt(3)).level(rs.getInt(7)).exp(rs.getInt(6)).gender(Employee.Gender.valueOf(rs.getString(4))).id(rs.getLong(1)).salary(rs.getFloat(5)).build();
	System.out.println(d);
		return d;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	
	public List<Dept>  getAll(){
		
		try(Connection conn = getConnection(this.sc)){
			System.out.println(".................");
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,LOCATION FROM DEPARTMENT");
			ResultSet rs=ps.executeQuery();
			List<Dept> deptSet=new ArrayList<Dept>();
			
			while(rs.next()) {
				deptSet.add(populateDepartment(rs));
				//return deptSet;
			}
			return deptSet;
			}catch(Exception e) {
				
			}
			//return deptSet;
			
		return null;
			
//		Set<Dept> setDept=new HashSet<Dept>();
//		for(int i:depts.keySet()) {
//			setDept.add(depts.get(i));
//		}
//		return setDept;
	}
	
	public void update(Dept d) {
		try (Connection conn=getConnection(this.sc)){
			System.out.println("In update method...");
			PreparedStatement ps=conn.prepareStatement("UPDATE DEPARTMENT SET NAME=?,LOCATION=?  WHERE ID=? ");
			setValuesToPrepareStatements(d, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated: "+rowsAffected);
			
		}catch(Exception e1) {
			
		}
	}

	

	@Override
	public Dept last() {
		DeptDAOImpl d=new DeptDAOImpl(this.sc);
		List<Dept> empList=d.getAll();
		int id= empList.stream().mapToInt(Dept::getId).max().orElseThrow();
		return d.getDept(id);

	}
	


	@Override
	public List<Employee> getEmployeesByDepartment(int dept_id) {
		
		
		try(Connection conn = getConnection(this.sc)){
			List<Employee> empSet=new ArrayList<Employee>();
			System.out.println(".................");
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE DEPT_ID=?");
			ps.setInt(1, dept_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Employee e=populateEmployee(rs);
				
				empSet.add(e);
				
			}return empSet;
			}catch(Exception e) {
				
				
			}
			return null;
	}

	private Employee populateEmployee(ResultSet rs) {
		try {
			Employee e=Employee.builder().name(rs.getString(2)).age(rs.getInt(3)).level(rs.getInt(7)).exp(rs.getInt(6)).gender(Employee.Gender.valueOf(rs.getString(4))).id(rs.getLong(1)).salary(rs.getFloat(5)).build();
		System.out.println(e);
			return e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
