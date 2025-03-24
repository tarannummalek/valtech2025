package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ranges.RangeException;



public class EmployeeDAOImpl implements EmployeeDAO {

	
	static {
		try {
		Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
	}
	
	
	private Connection getConnection() throws SQLException{

		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
	}
	
	
	@Override
	public void save(Employee e) {
		
		try(Connection conn = getConnection()){
			System.out.println(".................");
			PreparedStatement ps=conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID,DEPT_ID) VALUES(?,?,?,?,?,?,?,?)");
			setValuesToPrepareStatements(e, ps);
			
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows inserted: "+rowsAffected);
		}catch(Exception e1) {
			throw new RuntimeException(e1);
		}
		
	}




	@Override
	public void update(Employee e) {
		try (Connection conn=getConnection()){
			System.out.println("In update method...");
			PreparedStatement ps=conn.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?  WHERE ID=? ");
			setValuesToPrepareStatements(e, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated: "+rowsAffected);
			
		}catch(Exception e1) {
			
		}
		
	}

	@Override
	public void delete(int id) {
		
		try(Connection conn=getConnection()) {
			PreparedStatement ps=conn.prepareStatement("DELETE  FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			
			if(i>0) {
				//Employee e=populateEmployee(rs);
				System.out.println("rows deleted"+i);
				
			}else{
				throw new RuntimeException("No emp with id"+id);
			}
			
			}catch(Exception e) {
				
			}
			
	}

	@Override
	public Employee get(int id) {
		try(Connection conn=getConnection()) {
		PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPT_ID FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			Employee e=populateEmployee(rs);
			return e;
		}else{
			throw new RuntimeException("No emp with id"+id);
		}
		
		}catch(Exception e) {
			
			
		}
		return null;
		
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps=new ArrayList<Employee>();
		try (Connection conn=getConnection()){
			
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
			
			return emps;
			
		}catch(Exception e) {
			
		}
		return emps;
		
		
	}
	

	private Employee populateEmployee(ResultSet rs) {
		try {
			Employee e=Employee.builder().name(rs.getString(2)).age(rs.getInt(3)).level(rs.getInt(7)).exp(rs.getInt(6)).gender(Employee.Gender.valueOf(rs.getString(4))).id(rs.getLong(1)).salary(rs.getFloat(5))
					.build();
		System.out.println(e);
			return e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void setValuesToPrepareStatements(Employee e, PreparedStatement ps) throws SQLException {
		DeptDAOImpl d =new DeptDAOImpl(null);
		
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
		ps.setLong(8,e.getDeptId());
	}
}
