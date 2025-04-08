package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Customer;

public record CustomerVO(long id, String name, int age, String address, String pAddress) {

	
	public static CustomerVO from(Customer customer) {
		return new CustomerVO(customer.getId(), customer.getName(), customer.getAge(), customer.getAddress(), customer.getpAddress());
	}
	public Customer to(CustomerVO customerVO) {
		return new Customer(name, age, pAddress, address);
	}
}
