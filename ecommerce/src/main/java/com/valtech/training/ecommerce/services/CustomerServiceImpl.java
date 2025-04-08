package com.valtech.training.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.repos.CustomerRepo;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createCustomer(Customer custoemer) {
		customerRepo.save(custoemer);
	}
	
	@Override
	public Customer getCustomer(long id) {
		return customerRepo.getReferenceById(id);
	}

}
