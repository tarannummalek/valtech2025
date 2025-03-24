package services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Item;
import model.LineOrderItem;
import model.Order;
@Transactional(propagation = Propagation.SUPPORTS)
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void save(Item item) {
		itemDAO.save(item);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Item get(int id) {
		return itemDAO.get(id);
	}

	@Override
	public List<Item> getAll() {
		return itemDAO.getAll();
	}

	@Override
	public void update(Item item) {
		itemDAO.update(item);
	}

	@Override
	public void delete(int id) {
		itemDAO.delete(id);
	}
	@Override
	public void updateInventory(Order order) {
    order.getLineOrderItems().forEach(l->l.getItem().setCur_quantity(l.getItem().getCur_quantity()-l.getQuantity()));
    Set<LineOrderItem> lineOrderItems=order.getLineOrderItems();
    for (LineOrderItem lineOrderItem : lineOrderItems) {
		if(lineOrderItem.getItem().getCur_quantity()<=lineOrderItem.getItem().getReorderLevel()) {
			this.orderItemFromVendor(lineOrderItem.getItem());			
		}
	}

	}
	@Override
	public void orderItemFromVendor(Item item) {
		item.setCur_quantity(item.getMax_quantity());
		
	}
	
	@Override
	public boolean checkAvailabilityOfItems(Order order) {
		Set<LineOrderItem> lineOrderItems = order.getLineOrderItems();
		for (LineOrderItem lineOrderItem : lineOrderItems) {
			if(lineOrderItem.getItem().getCur_quantity()<=lineOrderItem.getQuantity()) {
				System.out.println(lineOrderItem.getItem().getName()+" is out of stock ");
				System.out.println("Order Quantity less than "+lineOrderItem.getItem().getReorderLevel());
				return false;
			}
		}
		return true;
	}
	
	
	

}
