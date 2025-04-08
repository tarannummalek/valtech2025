package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.repos.ItemRepo;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	
	@Autowired
	private InventoryService inventoryService;
	


	@Override
	public boolean isOrderPlaced(OrderVO order) {
		if(inventoryService.checkAvailabilityOfItems(order.to(order))) {
			
		orderRepo.save(order.to(order));
	
		//order.getLineOrderItems().forEach(l->lineOrderItemDAO.save(l));
		order.getLineOrderItems().stream().map(l->l.getItem()).forEach(i->itemRepo. save(i));;
		inventoryService.updateInventory(order.to(order));
		return true;
		}
		return false;
		
	}



	



	



	



}
