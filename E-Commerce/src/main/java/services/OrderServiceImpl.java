package services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ItemDAO;
import dao.LineOrderItemDAO;
import dao.OrderDAO;
import model.Item;
import model.LineOrderItem;
import model.Order;

public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private LineOrderItem lineOrderItem;
	
	@Autowired
	private LineOrderItemDAO lineOrderItemDAO;
	
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	public void setInventoryServiceImpl(InventoryServiceImpl inventoryServiceImpl) {
		this.inventoryServiceImpl = inventoryServiceImpl;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public boolean isOrderPlaced(Order order) {
		if(inventoryServiceImpl.checkAvailabilityOfItems(order)) {
			
		orderDAO.save(order);
		order.getLineOrderItems().forEach(l->lineOrderItemDAO.save(l));
		order.getLineOrderItems().stream().map(l->l.getItem()).forEach(i->itemDAO.save(i));;
		inventoryServiceImpl.updateInventory(order);
		return true;
		}
		return false;
		
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


}
