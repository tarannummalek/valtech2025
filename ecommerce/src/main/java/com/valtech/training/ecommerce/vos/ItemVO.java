package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;

public record ItemVO(long id,

		String name,

		String description,

		int reorderLevel,

		int max_quantity,

		int cur_quantity) {
	
	public static ItemVO from(Item item) {
		return new ItemVO(item.getId(), item.getName(), item.getDescription(), item.getReorderLevel(), item.getMax_quantity(), item.getCur_quantity());
	}
	public Item to(ItemVO vo) {
		return new Item(name, description, reorderLevel, max_quantity, cur_quantity);
	}

}
