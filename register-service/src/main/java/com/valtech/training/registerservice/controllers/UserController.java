package com.valtech.training.registerservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	UserVO register(@RequestBody UserVO userVO) {
		return userService.signUp(userVO);
	}
	
	@PostMapping("/subscription/{sid}")
	UserVO addUserToSubscription(@RequestBody UserVO userVO,long sid) {
		
		return userService.addUserToSubscription(userVO,sid);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<UserVO> getById(@PathVariable long id) {
		try {
		return ResponseEntity.ok(userService.getUser(id));}
		catch (Exception e) {
			return ResponseEntity.of(Optional.empty());
			// TODO: handle exception
		}
	}
	
	@GetMapping("/")
	List<UserVO> getAllUsers(){
		return userService.getAll();
		
	}
	
	@DeleteMapping("/{userId}")
	public void removeUser(@PathVariable("userId")long id) {
		
		userService.removeUser(id);
		
	}
	
	
	
	
	

}
