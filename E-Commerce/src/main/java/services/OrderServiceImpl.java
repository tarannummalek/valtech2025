package services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import dao.OrderDAO;
import model.Item;
import model.LineOrderItem;
import model.Order;

public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public boolean save(Order order) {

		Set<LineOrderItem> lineOrderItems = order.getLineOrderItems();
//if(l)
		//lineOrderItems.forEach(l-> if(l -> l.getItem().getCur_quantity() >= l.getQuantity()) {return true});
		for (LineOrderItem lineOrderItem : lineOrderItems) {
			if(lineOrderItem.getItem().getCur_quantity()>=lineOrderItem.getQuantity()) {
				return false;
			}
		}
		
		orderDAO.save(order);
		return true;
		
	}

	@Override
	public Order get(int id) {
		return orderDAO.get(id);
	}

	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public void update(Order order) {
		orderDAO.update(order);
	}

	@Override
	public void delete(int id) {
		orderDAO.delete(id);
	}

//	@Autowired
//	InventoryServiceImpl inventoryServiceImpl;
//	
//	
//	public void createOrder(Order order) {
//		
//		long order_id=order.getId();
//		
//		Set<Item> items=order.getItems();
//			
//		//items.forEach(i->i.);
//		
//		 Map<Item, Long> occurrences = items.stream()
//		            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		 
//		 
//		
//		
//	}
//
//	@Override
//	public void placeOrder(Order order) {
//		Set<Item> items=order.getItems();
//		
//		for (Item item : items) {
//			if(item.getCur_quantity()-1<=item.getReorderLevel()) {
//				inventoryServiceImpl.orderItemFromVendor(item);
//			}
//			
//		}
//		
//	}

}
