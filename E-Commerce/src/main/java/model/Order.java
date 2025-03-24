package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
	private long id;

	@Enumerated(EnumType.STRING)
	private Status status;

	public enum Status {
		ORDERED, PACKED, SHIPPED, DELIVERED
	}

	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(targetEntity = LineOrderItem.class, mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LineOrderItem> lineOrderItems;

	public Order() {
	}

	public Order(Status status) {

		this.status = status;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", customer=" + customer + ", lineOrderItems="
				+ lineOrderItems + "]";
	}

	public void addLineOrderItem(LineOrderItem lineOrderItem) {
		if (lineOrderItems == null)
			lineOrderItems = new HashSet<LineOrderItem>();
		lineOrderItems.add(lineOrderItem);

		lineOrderItem.setOrder(this);
	}

	public void removeaddLineOrderItem(LineOrderItem lineOrderitem) {
		lineOrderItems.remove(lineOrderitem);
		lineOrderitem.setOrder(null);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<LineOrderItem> getLineOrderItems() {
		return lineOrderItems;
	}

	public void setLineOrderItems(Set<LineOrderItem> lineOrderItems) {
		this.lineOrderItems = lineOrderItems;
	}
	

}
