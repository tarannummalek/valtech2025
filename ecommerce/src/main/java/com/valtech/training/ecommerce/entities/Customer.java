package com.valtech.training.ecommerce.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custseq")
	@SequenceGenerator(name = "custseq", sequenceName = "cust_seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String pAddress;
	@OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Order> orders;

	public Customer() {
	}

	public Customer(String name, int age, String address, String p_addresss) {
		super();

		this.name = name;
		this.age = age;
		this.address = address;
		this.pAddress = p_addresss;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String p_addresss) {
		this.pAddress = p_addresss;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", pAddress="
				+ pAddress + "]";
	}

	// helper

	public void addOrder(Order order) {
		if (orders == null)
			orders = new HashSet<Order>();
		orders.add(order);
		order.setCustomer(this);

	}

	public void removeOrder(Order order) {
		orders.remove(order);
		order.setCustomer(null);
	}

}
