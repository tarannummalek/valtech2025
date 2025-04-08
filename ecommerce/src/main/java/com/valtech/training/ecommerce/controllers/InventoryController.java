package com.valtech.training.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.ecommerce.services.InventoryService;
import com.valtech.training.ecommerce.vos.ItemVO;

@Controller
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/inventory")
	public String loginPage() {
		return "inventory";
		
	}
	
	@PostMapping("/inventory")
	public String addItem(@ModelAttribute ItemVO itemVO) {
		inventoryService.addItem(itemVO);
		return "inventory";
	}

}
