package spring.tx;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.w3c.dom.ranges.RangeException;

import spring.tx.Employee.Gender;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	
	static {
		try {
		Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
	}
	
	
	
	public EmployeeDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeDAOImpl(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

@Autowired
	private DataSource datasource;
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	public DataSource getDatasource() {
		return datasource;
	}
	
	private Connection getConnection() throws SQLException{
		return datasource.getConnection();

		//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
	}
	
	
	@Override
	public void save(Employee e) {
		
		new JdbcTemplate(datasource).update("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)",e.getName(),e.getAge(),e.getGender().toString(),e.getSalary(),e.getExp(),e.getLevel(),e.getId());
		
//		try(Connection conn = getConnection()){
//			System.out.println(".................");
//			PreparedStatement ps=conn.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)");
//			setValuesToPrepareStatements(e, ps);
//			
//			int rowsAffected=ps.executeUpdate();
//			System.out.println("Rows inserted: "+rowsAffected);
//		}catch(Exception e1) {
//			throw new RuntimeException(e1);
//		}
		
	}


	private void setValuesToPrepareStatements(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
	}

	@Override
	public void update(Employee e) {
		new JdbcTemplate(datasource).update("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?  WHERE ID=? ",e.getName(),e.getAge(),e.getGender().toString(),e.getSalary(),e.getExp(),e.getLevel(),e.getId());
		//	TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
//		try (Connection conn=getConnection()){
//			PreparedStatement ps=conn.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,GENDER=?,SALARY=?,EXPERIENCE=?,LEVEL=?  WHERE ID=? ");
//			setValuesToPrepareStatements(e, ps);
//			int rowsAffected=ps.executeUpdate();
//			System.out.println("Rows updated: "+rowsAffected);
//			
//		}catch(Exception e1) {
//			
//		}
		
	}

	@Override
	public void delete(int id) {
		
		new JdbcTemplate(datasource).update("DELETE  FROM EMPLOYEE WHERE ID=?",id);

		
//		try(Connection conn=getConnection()) {
//			PreparedStatement ps=conn.prepareStatement("DELETE  FROM EMPLOYEE WHERE ID=?");
//			ps.setInt(1, id);
//			int i=ps.executeUpdate();
//			
//			if(i>0) {
//				//Employee e=populateEmployee(rs);
//				System.out.println("rows deleted"+i);
//				
//			}else{
//				throw new RuntimeException("No emp with id"+id);
//			}
//			
//			}catch(Exception e) {
//				
//			}
			
	}

	@Override
	public Employee get(int id) {
		return new JdbcTemplate(datasource).queryForObject("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?",new Object[] { id},new EmployeeRowMapper());
//		
//		try(Connection conn=getConnection()) {
//		PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?");
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		
//		if(rs.next()) {
//			Employee e=populateEmployee(rs);
//			return e;
//		}else{
//			throw new RuntimeException("No emp with id"+id);
//		}
//		
//		}catch(Exception e) {
//			
//			
//		}
//		return null;
		
	}

	private Employee populateEmployee(ResultSet rs) {
		try {
			Employee e=Employee.builder().name(rs.getString(2)).age(rs.getInt(3)).level(rs.getInt(7)).exp(rs.getInt(6)).gender(Gender.valueOf(rs.getString(4))).id(rs.getLong(1)).salary(rs.getFloat(5)).build();
		System.out.println(e);
			return e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Employee> getAll() {
		
		
		return new JdbcTemplate(datasource).query("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE", new EmployeeRowMapper());
//		List<Employee> emps=new ArrayList<Employee>();
//		try (Connection conn=getConnection()){
//			
//			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				emps.add(populateEmployee(rs));
//			}
//			
//			return emps;
//			
//		}catch(Exception e) {
//			
//		}
//		return emps;
//		
		
	}
	
	
	private static class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			Employee e=Employee.builder().name(rs.getString(2)).age(rs.getInt(3)).level(rs.getInt(7)).exp(rs.getInt(6)).gender(Gender.valueOf(rs.getString(4))).id(rs.getLong(1)).salary(rs.getFloat(5)).build();
			System.out.println(e);
				return e;
			
			
		}
		
	}


}
