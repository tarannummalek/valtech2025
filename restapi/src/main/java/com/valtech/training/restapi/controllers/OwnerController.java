package com.valtech.training.restapi.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapi.services.OwnerService;
import com.valtech.training.restapi.services.WatchService;
import com.valtech.training.restapi.vos.OwnerVO;
import com.valtech.training.restapi.vos.WatchVO;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/")
	public OwnerVO createOwner(@RequestBody OwnerVO ownerVO) {
		return ownerService.createOwner(ownerVO);
	}
	
	@PutMapping("/{id}")
	public OwnerVO updateOwner(@PathVariable("id")long id,@RequestBody OwnerVO ownerVO) {
		return ownerService.updateOwner(id, ownerVO);
	}
	
	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable("id") long id) {
		System.out.println("in get watch");
		return ownerService.getOwnerById(id);
	}
	@GetMapping("/")
	public List<OwnerVO> getOwners(){
			return ownerService.getAllOwners();
	}
	
	@PutMapping("/{id}/watches")
	public OwnerVO updateWatches(@PathVariable("id") long id,@RequestBody List<Long> watches) {
		return ownerService.addWatchesToOwner(id,watches);
	}
}
