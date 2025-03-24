package services;

import java.util.List;

import model.Item;
import model.Order;

public interface InventoryService {

	void save(Item item);

	Item get(int id);

	List<Item> getAll();

	void update(Item item);

	void delete(int id);
	
	void updateInventory(Order order);
	
	void orderItemFromVendor(Item item) ;

	boolean checkAvailabilityOfItems(Order order);

	
	

}