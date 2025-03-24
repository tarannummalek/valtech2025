package com.valtech.training.restapi.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restapi.entities.Owner;
import com.valtech.training.restapi.entities.Watch;

public class OwnerVO {

	
	private long id;
	private String name;
	private String mobile;
	private String email;
	private List<Long> watches;
	public OwnerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OwnerVO(long id, String name, String mobile, String email,List<Long> watches)  {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.watches=watches;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static OwnerVO from(Owner o) {
		
		List<Long> watches=(o.getWatches()==null)?List.of():o.getWatches().stream().map(o1->o1.getId()).collect(Collectors.toList());
		return new OwnerVO(o.getId(),o.getName(), o.getMobile(), o.getEmail(),watches);
	}
	
	public Owner toOwner(OwnerVO o) {
		Owner o1=new Owner(id, name, mobile, email);
		return o1;
		
	}
	
	public void updateOwnerFromVO(Owner o) {
		o.setEmail(email);
		o.setMobile(mobile);
		o.setName(name);
		
	}
}
