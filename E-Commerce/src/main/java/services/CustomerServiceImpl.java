package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDAO;
import model.Customer;

@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Customer custoemer) {
		customerDAO.save(custoemer);
	}
	@Transactional(propagation = Propagation.REQUIRED)	
	public Customer get(int id) {
		return customerDAO.get(id);
	}
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}
	public void update(Customer customer) {
		customerDAO.update(customer);
	}
	public void delete(int id) {
		customerDAO.delete(id);
	}
	@Override
	public void disable(int id) {
		customerDAO.disable(id);
	}
	
	
	
	
	
	
		
	
	

}
