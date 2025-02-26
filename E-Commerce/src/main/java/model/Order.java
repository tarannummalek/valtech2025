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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq" ,allocationSize = 1)
	private long id;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	public enum Status{
		ORDERED,PACKED,SHIPPED,DELIVERED
	}
	
	@ManyToOne(targetEntity = Customer.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	Customer customer;
	
	
	@OneToMany(targetEntity = LineOrderItem.class,mappedBy = "order",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	 Set<LineOrderItem> lineOrderItems;
	
//	@ManyToMany(targetEntity = Item.class,fetch = FetchType.LAZY)
//	@JoinTable(name="line_order_items",
//				joinColumns = @JoinColumn(name="order_id",referencedColumnName = "id"),
//				inverseJoinColumns = @JoinColumn(name="item_id",referencedColumnName = "id"))
//	private Set<Item> items;
	
	public Order( Status status) {
		
	this.status=status;
		
	
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
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

//	public Set<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<Item> items) {
//		this.items = items;
//	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", customer=" + customer + "]";
	}
	public void addLineOrderItem(LineOrderItem lineOrderItem ) {
		if(lineOrderItems==null) lineOrderItems=new HashSet<LineOrderItem>();
		lineOrderItems.add(lineOrderItem);
		if(lineOrderItem.getOrder()==null)lineOrderItems=new HashSet<LineOrderItem>();
		
		lineOrderItems.add(lineOrderItem);
			
		}
	
	public void removeaddLineOrderItem(LineOrderItem lineOrderitem) {
		//items.remove(item);
		lineOrderItems.remove(this);
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
