
package com.valtech.training.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity

public class LineOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineOrderItem")
	@SequenceGenerator(name = "lineOrderItem", sequenceName = "lineorderitem", allocationSize = 1)
	private long id;

	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;

	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	private int Quantity;

	public LineOrderItem() {
	}

	public LineOrderItem(Item item, Order order, int quantity) {
		super();

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

	@Override
	public String toString() {
		return "LineOrderItem [id=" + id + ", Quantity=" + Quantity + "]";
	}
	
	

}
