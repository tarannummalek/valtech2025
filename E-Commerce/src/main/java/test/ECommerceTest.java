package test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Customer;
import model.Item;
import model.LineOrderItem;
import model.Order;
import model.Order.Status;
import services.CustomerService;
import services.ItemService;
import services.LineOrderItemService;
import services.OrderService;


public class ECommerceTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ecommerce.xml");
		CustomerService es=context.getBean(CustomerService.class);
		OrderService os=context.getBean(OrderService.class);
		ItemService is=context.getBean(ItemService.class);
		LineOrderItemService lois=context.getBean(LineOrderItemService.class);
		//es.getAll().forEach(e->System.out.println(e));
		System.out.println(es.getClass().getName());
		Customer c=new Customer("erer",11,"paris","paris");
		Order o=new Order(Order.Status.ORDERED);
		Item i=new Item("laptop", "Dell inspiron", 3, 50,6);
		Item i1=new Item("lap", "Dell", 3, 50,6);
		Item i2=new Item("laptop", "Dell inspiron", 3, 50,6);
		LineOrderItem lo1 = new LineOrderItem(0, i, o, 2);
		LineOrderItem lo2= new LineOrderItem(0, i1 ,o, 2);
		LineOrderItem lo3= new LineOrderItem(0, i2 ,o, 2);
		
		o.addLineOrderItem(lo3);
		o.addLineOrderItem(lo2);
		es.save(c);
		os.save(o);
		
//		is.save(i);
//		is.save(i1);
//		is.save(i2);
		
//		lois.save(lo3);
//		lois.save(lo1);
//		lois.save(lo2);
		

//			o.addItem(i);
			o.setCustomer(c);
			
//			o.addItem(i);
//			o.addItem(i2);
		

		//OrderService es1=context.getBean(OrderService.class);
		//es1.placeOrder(o);
		//es1.c
		
		
		
		//Customer e=es.update();
		//System.out.println(e);
		context.close();
	
//		SessionFactory sf =new AnnotationConfiguration().addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).addAnnotatedClass(Order.class).buildSessionFactory(); 
//
//		Session session=sf.openSession();
//		Transaction transaction=session.beginTransaction();
////		//transaction.s
////		
//		Customer c=new Customer( "jack", 55, "paris", "paris");
//		Item i=new Item("laptop", "Dell inspiron", 3, 50,6);
//		
	
//		
//		
////		o.addItem(i);
//		o.setCustomer(c);
	//	o.addItem(i);
//		session.save(c);
//		session.save(i);
//		session.save(o);
		//i.
		
		//Customer c=(Customer) session.load(Customer.class, 1L);
		//System.out.println(c);
		
		//c.addOrder(o);
		
//		transaction.commit();
//		session.close();
//		sf.close();
	
	}

}
