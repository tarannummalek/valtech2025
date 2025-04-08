package com.valtech.training.ecommerce.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.ecommerce.entities.LineOrderItem;
import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.entities.Order.Status;

public class OrderVO {
	private long id;
	private Status status;
	private long custId;
	private List<LineOrderItem> lineOrderItems;


	
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderVO(long id, Status status, long custId, List<LineOrderItem> lineOrderItems) {
		super();
		this.id = id;
		this.status = status;
		this.custId = custId;
		this.lineOrderItems = lineOrderItems;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public List<LineOrderItem> getLineOrderItems() {
		return lineOrderItems;
	}

	public void setLineOrderItems(List<LineOrderItem> lineOrderItems) {
		this.lineOrderItems = lineOrderItems;
	}

	public static OrderVO from(Order order) {
		return new OrderVO(order.getId(),order.getStatus(),order.getCustomer().getId(),order.getLineOrderItems().stream().toList());
		
	}
	public Order to(OrderVO 
			orderVO) {
		
		Order order=new Order(id, status, custId);
		return order;
	}
}
