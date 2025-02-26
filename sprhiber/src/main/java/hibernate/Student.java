package hibernate;

import java.util.jar.Attributes.Name;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Column;
@Entity
public class Student {
	
	@EmbeddedId
	private StudentId studentId;
	private String name;
	private String fatherName;
	private long mobile;
	private String stream;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column =@Column(name="home_street")),
		@AttributeOverride(name = "city",column =@Column(name="home_city")),
		@AttributeOverride(name = "pincode",column =@Column(name="home_pincodec"))
		
	})
	private StudentAddress homeAddress;
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "street",column =@Column(name="curr_street")),
//		@AttributeOverride(name = "city",column =@Column(name="curr_city")),
//		@AttributeOverride(name = "pincode",column =@Column(name="curr_pincodec"))
//		
//	})
//	private StudentAddress currAddress;
	
	
	
	public Student( String name, String fatherName, long mobile, String stream,
			StudentAddress homeAddress,StudentId studentId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.fatherName = fatherName;
		this.mobile = mobile;
		this.stream = stream;
		this.homeAddress = homeAddress;

	}
	public Student( String name, String fatherName, long mobile, String stream,StudentId studentId) {
	
		this.studentId = studentId;
		this.name = name;
		this.fatherName = fatherName;
		this.mobile = mobile;
		this.stream = stream;
	}
	public Student() {
	}
	public StudentId getStudentId() {
		return studentId;
	}
	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public StudentAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(StudentAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
//	public StudentAddress getCurrAddress() {
//		return currAddress;
//	}
//	public void setCurrAddress(StudentAddress currAddress) {
//		this.currAddress = currAddress;
//	}
	

}
