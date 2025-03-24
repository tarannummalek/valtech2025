package com.valtech.training.restapi.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapi.entities.Watch;
import com.valtech.training.restapi.services.WatchService;
import com.valtech.training.restapi.vos.WatchVO;

@RestController
@RequestMapping("/api/v1/watches")
public class WatchController {
	
	@Autowired
	private WatchService watchService;
	
	
	
	@PostMapping("/")
	public WatchVO createWatch(@RequestBody WatchVO watch) {
		return watchService.createWatch(watch);
	}
	
	@PutMapping("/{id}")
	public WatchVO updateWatch(@PathVariable("id")long id,@RequestBody WatchVO watch) {
		return watchService.updateWatch(id,watch);
	}
	
	@GetMapping("/")
	public List<WatchVO> getWatches(@RequestParam(name="brand",required = false)String brand){
		if(brand==null) {
		return watchService.getWatches();}
		else {
			return watchService.getWatchesByBrand(brand);
		}
		
	}
	
	@GetMapping("/{id}")
	public WatchVO getWatch(@PathVariable("id") long id) {
		System.out.println("in get watch");
		return watchService.getWatch(id);
	}
	


}
