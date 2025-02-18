package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {

	Student getStudent(int id);
	int addStudent(Student student);
	int delete(int id);
	int update(Student student);
	List<Student> getAllStudents();
	
	
	
}
