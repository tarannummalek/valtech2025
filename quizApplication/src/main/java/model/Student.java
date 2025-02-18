package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Student {
	
	private String  name;
	private int id;
	private Date birthDate;
	private List<Quiz> attendedQuizes;
	public Student() {
	}
	public Student( int id,String name,Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public List<Quiz> getAttendedQuizes() {
		return attendedQuizes;
	}
	public void setAttendedQuizes(List<Quiz> attendedQuizes) {
		this.attendedQuizes = attendedQuizes;
	}
	
	
	

}
