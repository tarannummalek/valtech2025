package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.Item;
import model.Item;

public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private Item item;
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Item item) {
		
		new HibernateTemplate(sessionFactory).save(item);
		
		
	}

	@Override
	public Item get(int id) {
		Long id1=(long) id;
		return new HibernateTemplate(sessionFactory).load(Item.class, id1);
	
	}

	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from items e");
	}

	@Override
	public void update(Item item) {
		new HibernateTemplate(sessionFactory).update(item);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
		
	}
	
	

}
