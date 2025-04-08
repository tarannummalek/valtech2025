package com.valtech.training.ecommerce.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.LineOrderItem;
import com.valtech.training.ecommerce.entities.Order;
import com.valtech.training.ecommerce.repos.ItemRepo;
import com.valtech.training.ecommerce.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class InventoryServiceImpl implements InventoryService {
    @Autowired
	private ItemRepo itemRepo;
	
	@Override
	public void updateInventory(Order order) {
		order.getLineOrderItems()
				.forEach(l -> l.getItem().setCur_quantity(l.getItem().getCur_quantity() - l.getQuantity()));
		Set<LineOrderItem> lineOrderItems = order.getLineOrderItems();
		for (LineOrderItem lineOrderItem : lineOrderItems) {
			if (lineOrderItem.getItem().getCur_quantity() <= lineOrderItem.getItem().getReorderLevel()) {
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
			if (lineOrderItem.getItem().getCur_quantity() <= lineOrderItem.getQuantity()) {
				System.out.println(lineOrderItem.getItem().getName() + " is out of stock ");
				System.out.println("Order Quantity less than " + lineOrderItem.getItem().getReorderLevel());
				return false;
			}
		}
		return true;
	}
	@Override
	public List<ItemVO> getAllItems(){
		return itemRepo.findAll().stream().map(i->ItemVO.from(i)).collect(Collectors.toList());
	}

	@Override
	public void addItem(ItemVO itemVO) {
		itemRepo.save(itemVO.to(itemVO));
		
	}

}
