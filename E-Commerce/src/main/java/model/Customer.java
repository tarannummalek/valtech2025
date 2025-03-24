package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private String p_addresss;
	@OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Order> orders;

	public Customer() {
	}

	public Customer(String name, int age, String address, String p_addresss) {
		super();

		this.name = name;
		this.age = age;
		this.address = address;
		this.p_addresss = p_addresss;

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

	public String getP_addresss() {
		return p_addresss;
	}

	public void setP_addresss(String p_addresss) {
		this.p_addresss = p_addresss;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", p_addresss="
				+ p_addresss + "]";
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
