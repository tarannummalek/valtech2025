	package com.valtech.training.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.InventoryService;
import com.valtech.training.ecommerce.vos.CustomerVO;
import com.valtech.training.ecommerce.vos.ItemVO;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "register";
		
	}
	
	@PostMapping("/login")
	public String createCustomer(@ModelAttribute CustomerVO customerVO,Model model) {
		customerService.createCustomer(customerVO.to(customerVO));
		model.addAttribute("name",customerVO.name());
		List<ItemVO> items=inventoryService.getAllItems();
		model.addAttribute("items",items);
		return "dashboard";
		
	}
	

}
