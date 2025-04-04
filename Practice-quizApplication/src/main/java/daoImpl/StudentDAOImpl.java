package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import jakarta.servlet.ServletContext;
import model.Student;

public class StudentDAOImpl implements StudentDAO{
	static {
		try {
		Class.forName("org.postgresql.Driver");}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
	}
	ServletContext sc;
	
	public StudentDAOImpl() {
	}
	
	public StudentDAOImpl(ServletContext sc) {
		this.sc=sc;
		
	}
	
	private Connection getConnection(ServletContext sc) throws SQLException {
		
		String username =(String) sc.getAttribute("username");
		String password=(String) sc.getAttribute("password");
		String url=(String) sc.getAttribute("url");
		
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		
	}

	@Override
	public Student getStudent(int id) {
		try(Connection conn=getConnection(this.sc) ){
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,BIRTHDATE FROM STUDENT WHERE ID= ?");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				Student student=populateStudent(rs);
				return student;
			}{
				System.out.println("No student with id :"+id);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Student populateStudent(ResultSet rs) throws SQLException {
		Student s=new Student (rs.getInt(1),rs.getString(2),rs.getDate(3));
		return s;
	}

	@Override
	public int addStudent(Student student) {
		try(Connection conn=getConnection(this.sc)){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO STUDENT (NAME,BIRTHDATE)VALUES (?,?)");
			ps.setString(1, student.getName());
			ps.setDate(2, (Date) student.getBirthDate());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try(Connection conn=getConnection(this.sc)){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM STUDENT WHERE ID= ?");
		ps.setInt(0, id);
		return ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Student student) {
		try(Connection conn=getConnection(this.sc)){
			PreparedStatement ps=conn.prepareStatement("UPDATE STUDENT SET NAME=? BIRTHDATE=? WHERE ID=?");
			ps.setString(1, student.getName());
			ps.setDate(2, (Date) student.getBirthDate());
			ps.setInt(3, student.getId());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=new ArrayList<Student>();
		try(Connection conn=getConnection(this.sc)){
			PreparedStatement ps =conn.prepareStatement("SELECT ID,NAME,BIRTHDATE FROM STUDENT");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				students.add(populateStudent(rs));
			}
			return students;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
