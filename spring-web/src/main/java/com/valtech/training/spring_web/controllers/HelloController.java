package com.valtech.training.spring_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.spring_web.vos.LoginVO;

@Controller
public class HelloController {
	
//	public ModelAndView test() {
//		ModelAndView view =new ModelAndView("login");
//		view.addObject("message","Please use login dialogue");
//	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hellospringweb";
		
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
		
	}
	
	@PostMapping("/login")
	public String handleLoginForm( @ModelAttribute LoginVO login,Model model) {
		if("scott".equals(login.getUsername())&&"tiger".equals(login.getPassword()))
		{	model.addAttribute("login",login);
		return "dashboard";}else {
		model.addAttribute("message","Invalid Username Password");
		return "login";}
	}
	
	//get method

}
