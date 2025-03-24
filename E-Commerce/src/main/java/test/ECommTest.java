package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Customer;
import model.Item;
import model.LineOrderItem;
import model.Order;
import services.CustomerService;
import services.InventoryService;
import services.LineOrderItemService;
import services.OrderService;

class ECommTest {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	ClassPathXmlApplicationContext context;
	
//	@BeforeAll
//	void loadBeans() {
//		context=new ClassPathXmlApplicationContext("ecommerce.xml");
//		CustomerService es=context.getBean(CustomerService.class);
//		OrderService os=context.getBean(OrderService.class);
//		InventoryService is=context.getBean(InventoryService.class);
//		LineOrderItemService lois=context.getBean(LineOrderItemService.class);
//	}

	//it will test whether order is placed or not 
	@Test
	void testOrderService() {
//		//assertFalse(orderService.isOrderPlaced(null));
//		
//		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ecommerce.xml");
//		CustomerService es=context.getBean(CustomerService.class);
//		OrderService os=context.getBean(OrderService.class);
//		InventoryService is=context.getBean(InventoryService.class);
//		LineOrderItemService lois=context.getBean(LineOrderItemService.class);
//		//es.getAll().forEach(e->System.out.println(e));
//		System.out.println(es.getClass().getName());
//		Customer c=new Customer("erer",11,"paris","paris");
//		Order o=new Order(Order.Status.ORDERED);
//		Item i=new Item("laptop", "Dell inspiron", 3, 50,6);
//		Item i1=new Item("lap", "Dell", 3, 50,6);
//		Item i2=new Item("laptop", "Dell inspiron", 3, 50,6);
//		LineOrderItem lo1 = new LineOrderItem( i, o, 2);
//		LineOrderItem lo2= new LineOrderItem( i1 ,o, 7);
//		LineOrderItem lo3= new LineOrderItem( i2 ,o, 2);
//		//LineOrderItem lo4= new LineOrderItem( i2 ,o, 6);
//		
//		o.setCustomer(c);
//		System.out.println(c);
//		//o.setCustomer(c);
//		o.addLineOrderItem(lo3);
//		o.addLineOrderItem(lo2);
//		//o.addLineOrderItem(lo4);
//		HashSet<Order> h=new HashSet<>();
//		h.add(o);
//		c.setOrders(h);
//		System.out.println(o);
//
//		is.save(i);
//		is.save(i1);
//		is.save(i2);
//		System.out.println(i.getId());
//		System.out.println(i1.getId());
//		System.out.println(i2.getId());
//		lois.save(lo3);
//		lois.save(lo2);
//
//		es.save(c);
//		assertFalse(os.isOrderPlaced(o));

//		context.close();
		//os.isOrderPlaced(o);
		
//		assertTrue(os.isOrderPlaced(o));
//		lois.save(lo3);
//		lois.save(lo2);
//		lois.save(lo1);
//		is.update(i);
//		assertTrue(os.isOrderPlaced(o1));
		
//		lois.save(lo3);
//		lois.save(lo2);
//		lois.save(lo1);
//		is.update(i);
//		assertTrue(os.isOrderPlaced(o2));
//		if(!os.isOrderPlaced(o)) {
//			System.out.println("Oredred item is out of stock");
//		}
//		else {
//			System.out.println("your order has been placed"
//					+ "");
//		}

	
				
	}

	
	
	@Test 
	void testInventoryService() {
		
		context=new ClassPathXmlApplicationContext("ecommerce.xml");
		CustomerService es=context.getBean(CustomerService.class);
		OrderService os=context.getBean(OrderService.class);
		InventoryService is=context.getBean(InventoryService.class);
		
		

//		Order order=os.get(2);
//		Item i=is.get(6);
//		order.addLineOrderItem(new LineOrderItem(i,order,7));
//		System.out.println(i.getCur_quantity());
//		
//		//assertEquals(true, os.isOrderPlaced(order));
//		
//		assertEquals(false, is.checkAvailabilityOfItems(order));
		
		Order order1=os.get(15);
		
		System.out.println(order1);
		Item i1=is.get(8);
		//order1.addLineOrderItem(new LineOrderItem(i1,order1,1));
		
		System.out.println(i1.getCur_quantity());
		
		assertEquals(true, is.checkAvailabilityOfItems(order1));
		
		
		assertEquals(50, i1.getCur_quantity());
		
		is.updateInventory(order1);
		
		assertEquals(50, i1.getCur_quantity());
		
		
		
	
		
	//	is.orderItemFromVendor(i);
		
	//	is.save(i);
		//assertEquals(i.getMax_quantity(),i.getCur_quantity() );
		
		
//		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ecommerce.xml");
//		CustomerService es=context.getBean(CustomerService.class);
//		OrderService os=context.getBean(OrderService.class);
//		InventoryService is=context.getBean(InventoryService.class);
//		LineOrderItemService lois=context.getBean(LineOrderItemService.class);
//		//es.getAll().forEach(e->System.out.println(e));
////		System.out.println(es.getClass().getName());
//		Customer c=new Customer("erer",11,"paris","paris");
//		Order o=new Order(Order.Status.ORDERED);
//		Order o1=new Order(Order.Status.ORDERED);
//		Order o2=new Order(Order.Status.ORDERED);
//		Item i=new Item("laptop", "Dell inspiron", 3, 50,6);
////		Item i1=new Item("lap", "Dell", 23, 50,6);
////		Item i2=new Item("laptop", "Dell inspiron", 3, 50,6);
//		LineOrderItem lo1 = new LineOrderItem(i , o, 2);
//		LineOrderItem lo2= new LineOrderItem(i,o1, 2);
//		LineOrderItem lo3= new LineOrderItem( i,o2, 3);
		//LineOrderItem lo4= new LineOrderItem( i2 ,o, 6);
		//Customer c=es.get(2);
//		o.setCustomer(c);
//		o1.setCustomer(c);
//		o2.setCustomer(c);
//		//System.out.println(c);
//		//o.setCustomer(c);
//		o1.addLineOrderItem(lo3);
//		o2.addLineOrderItem(lo2);
//		o.addLineOrderItem(lo1);
//		
//		//o.addLineOrderItem(lo4);
//		
//		c.addOrder(o);
//		c.addOrder(o1);
//		c.addOrder(o2);
//		System.out.println(o);


//		System.out.println(i.getId());
//		System.out.println(i1.getId());
//		System.out.println(i2.getId());
		



		

//		is.save(i1);
//		is.save(i2);
		context.close();
		
		
	}
	
//	
//	@Test
//	void testCusomerService(){
//		
//	}
//	@AfterAll
//	void contextDestroyed() {
//		//context.close();
//	}
}
