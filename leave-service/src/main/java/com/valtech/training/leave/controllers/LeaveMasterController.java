package com.valtech.training.leave.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.leave.services.LeaveService;
import com.valtech.training.leave.vos.LeaveMasterVO;

@RestController
@RequestMapping("	")
public class LeaveMasterController {
	
	@Autowired
	private LeaveService leaveService;
	
	@GetMapping("/{id}")
	public LeaveMasterVO getLeaveMaster(@PathVariable("id")long id){
		return leaveService.getLeaveMaster(id);
	}
	
	@PostMapping("/")
	public LeaveMasterVO createLeave(@RequestBody  LeaveMasterVO leaveMasterVO) {
		return leaveService.saveOrUpdateLeaveMaster(leaveMasterVO);
	}
	
	@GetMapping("/")
	public List<LeaveMasterVO> getAllLeaveMasters(){
		return leaveService.getAllLeaveMasters();
	}

}
