package hiber.practice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stuseq")
	@SequenceGenerator(name = "stuseq" ,sequenceName="stu_seq", allocationSize = 1)
	private int id;
	private String name;
	@ManyToOne
	private Course course;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( String name) {
		this.name = name;

	}
	
	

}
