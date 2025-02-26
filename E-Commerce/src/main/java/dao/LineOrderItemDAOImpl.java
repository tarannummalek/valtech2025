package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.LineOrderItem;

public class LineOrderItemDAOImpl implements LineOrderItemDAO {
	
	@Autowired
	private LineOrderItem lineOrderItem;
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(LineOrderItem item) {
		
		new HibernateTemplate(sessionFactory).save(item);
		
		
	}

	@Override
	public LineOrderItem get(int id) {
		return new HibernateTemplate(sessionFactory).load(LineOrderItem.class, id);
	
	}

	@Override
	public List<LineOrderItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from items e");
	}

	@Override
	public void update(LineOrderItem item) {
		new HibernateTemplate(sessionFactory).update(item);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
		
	}

}
