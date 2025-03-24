package com.valtech.training.restapi.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restapi.entities.Watch;

public class WatchVO {
	
	private long id;
	private String brand;
	private String model;
	private String color;
	private float price;
	private String type;
	private long ownerId;
	
	
	public WatchVO() {
	}
	public WatchVO(long id, String brand, String model, String color, float price, String type,long ownerId) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.price = price;
		this.type = type;
		this.ownerId=ownerId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public static WatchVO from(Watch watch) {
		return new WatchVO(watch.getId(),watch.getBrand(),watch.getModel(),watch.getColor(),watch.getPrice(),watch.getType(),watch.getOwner().getId());
	}
	public Watch toWatch() {
		Watch watch=new Watch(brand,model,color,price,type);
		watch.setId(id);
		return watch;
		
		
	}
	
	public void updateWatchFromVO(Watch w) {
		w.setBrand(brand);
		w.setColor(color);
		w.setModel(model);
		w.setPrice(price);
		w.setType(type);
	}
	
	public static List<WatchVO> toWatchVOList(List<Watch> watches){
		return watches.stream().map(w->WatchVO.from(w)).collect(Collectors.toList());
		
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	

}
