package com.valtech.training.first.dtos;

public class BookInfoDTO{
	private String publisherName;
	private int price;
	public BookInfoDTO(String pName,int price) {
		this.price=price;
		this.publisherName=pName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public BookInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookInfoDTO [publisherName=" + publisherName + ", price=" + price + "]";
	}
	
	
}
