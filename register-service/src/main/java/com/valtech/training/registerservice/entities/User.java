package com.valtech.training.registerservice.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
	private Long id;
	private int age;
	private String name;
	private int mobile;
	private String email;
	private boolean isKid;
	
	@ManyToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_id",referencedColumnName = "id")
	private Subscription subscription;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	public User(int age, String name, int mobile, String email, boolean isKid) {
		super();
		this.age = age;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.isKid = isKid;
		
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isKid() {
		return isKid;
	}


	public void setKid(boolean isKid) {
		this.isKid = isKid;
	}


	public Subscription getSubscription() {
		return subscription;
	}


	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

  
	
	
	
	
	
	

}
