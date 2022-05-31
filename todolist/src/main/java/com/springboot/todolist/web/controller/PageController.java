package com.springboot.todolist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/index")
	public String index() {
		
		return "todolist/todolist";
	}
	
	@GetMapping("/auth/signup")
	public String signup() {
		
		return "/auth/signup";
	}
	
	@GetMapping("/auth/signin")
	public String signin() {
		
		return "/auth/signin";
	}
	

}
