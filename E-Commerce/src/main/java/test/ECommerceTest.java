package test;



import java.util.HashSet;

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
import services.InventoryService;

import services.LineOrderItemService;
import services.OrderService;


public class ECommerceTest {
	
	

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ecommerce.xml");
		CustomerService es=context.getBean(CustomerService.class);
		OrderService os=context.getBean(OrderService.class);
		InventoryService is=context.getBean(InventoryService.class);
		LineOrderItemService lois=context.getBean(LineOrderItemService.class);
		//es.getAll().forEach(e->System.out.println(e));
		System.out.println(es.getClass().getName());
		Customer c=new Customer("erer",11,"paris","paris");
		Order o=new Order(Order.Status.ORDERED);
		Item i=new Item("laptop", "Dell inspiron", 3, 50,6);
		Item i1=new Item("lap", "Dell", 3, 50,6);
		Item i2=new Item("laptop", "Dell inspiron", 3, 50,6);
		LineOrderItem lo1 = new LineOrderItem( i, o, 2);
		LineOrderItem lo2= new LineOrderItem( i1 ,o, 7);
		LineOrderItem lo3= new LineOrderItem( i2 ,o, 2);
		//LineOrderItem lo4= new LineOrderItem( i2 ,o, 6);
		
		o.setCustomer(c);
		System.out.println(c);
		//o.setCustomer(c);
		o.addLineOrderItem(lo3);
		o.addLineOrderItem(lo2);
		//o.addLineOrderItem(lo4);
		HashSet<Order> h=new HashSet<>();
		h.add(o);
		c.setOrders(h);
		System.out.println(o);
		
		es.save(c);
		lois.save(lo3);
		lois.save(lo2);
	

		es.save(c);
		
		//os.isOrderPlaced(o);
		if(!os.isOrderPlaced(o)) {
			System.out.println("Oredred item is out of stock");
		}
		else {
			System.out.println("your order has been placed"
					+ "");
		}
		is.save(i);
		is.save(i1);
		is.save(i2);
		context.close();
	
	
	}

}
