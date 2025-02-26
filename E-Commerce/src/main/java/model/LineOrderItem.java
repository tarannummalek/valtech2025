package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity

public class LineOrderItem {
	
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineOrderItem")
	@SequenceGenerator(name = "lineOrderItem",sequenceName = "line_order_item" )
	private long id;

	@ManyToOne(targetEntity = Item.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Item item;
	
	@ManyToOne(targetEntity = Order.class,cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Order order;
	
	private int Quantity;

	public LineOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineOrderItem(long id, Item item, Order order, int quantity) {
		super();
		this.id = id;
		this.item = item;
		this.order = order;
		Quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	

}
