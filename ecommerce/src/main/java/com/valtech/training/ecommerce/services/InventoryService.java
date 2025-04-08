package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.vos.ItemVO;

public interface InventoryService {

	void updateInventory(Order order);

	void orderItemFromVendor(Item item);

	boolean checkAvailabilityOfItems(Order order);

	List<ItemVO> getAllItems();

	void addItem(ItemVO itemVO);

}