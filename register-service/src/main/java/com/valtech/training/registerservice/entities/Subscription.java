package com.valtech.training.registerservice.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub_seq")
	@SequenceGenerator(name = "sub_seq",sequenceName = "sub_seq",allocationSize = 1 )
	private Long id;
	private int amount;
	private LocalDate subscriptionStart;
	private LocalDate subscriptionEnd;
	
	@OneToMany(mappedBy = "subscription",targetEntity = User.class,fetch = FetchType.LAZY)
	private List<User> users;
	
	public Subscription() {
	}
	public Subscription( int amount, LocalDate subscriptionStart, LocalDate subscriptionEnd) {
		
		this.amount = amount;
		this.subscriptionStart = subscriptionStart;
		this.subscriptionEnd = subscriptionEnd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setSubscriptionStart(LocalDate subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}
	public void setSubscriptionEnd(LocalDate subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void addUser(User u) {
		if(users==null) users=new ArrayList<User>();
		users.add(u);
		u.setSubscription(this);
	}
	public void remove(User u) {
		users.remove(u);
		u.setSubscription(null);
	}
	 

}
