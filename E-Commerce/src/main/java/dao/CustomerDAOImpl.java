package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.Customer;


public class CustomerDAOImpl implements CustomerDAO {
	


	
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Customer custoemer) {
		
		new HibernateTemplate(sessionFactory).save(custoemer);
		
		
	}

	@Override
	public Customer get(int id) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, id);
	
	}

	@Override
	public List<Customer> getAll() {
		return new HibernateTemplate(sessionFactory).find("from customers e");
	}

	@Override
	public void update(Customer customer) {
		new HibernateTemplate(sessionFactory).update(customer);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
		
	}
	


	
	
	

}
