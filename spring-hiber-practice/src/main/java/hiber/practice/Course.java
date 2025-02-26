package hiber.practice;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Course {
	
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseq")
	@SequenceGenerator(name = "courseq",sequenceName = "cour_seq",allocationSize = 1)
	private String id;
	private String name;
	
	@OneToMany
	private Set<Student>  students ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Course(String name) {
		this.name = name;

	}
	public Course() {

		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
