package com.valtech.training.ecommerce.vos;

import java.util.List;

public class PlaceOrderVO{
	private List<ItemVO> items;
	private long custId;
	public PlaceOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlaceOrderVO(List<ItemVO> items, long custId) {
		super();
		this.items = items;
		this.custId = custId;
	}
	public List<ItemVO> getItems() {
		return items;
	}
	public void setItems(List<ItemVO> items) {
		this.items = items;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	
	
}
	
	


