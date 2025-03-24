package services;

import java.util.List;

import model.Customer;

public interface CustomerService {
	
	void save(Customer custoemer);
	Customer get(int id);
	List<Customer> getAll();
	void update(Customer customer);
	void delete(int id);
	void disable(int id);
}
