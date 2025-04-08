package com.valtech.training.ecommerce.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;

public interface CustomerService {

	void createCustomer(Customer custoemer);

	Customer getCustomer(long id);

}