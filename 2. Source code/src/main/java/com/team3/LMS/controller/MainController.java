package com.team3.LMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class MainController {
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index2";
    }
    
    @GetMapping("/index") 
	public String index() {
		return "index2";
	}
    
	@GetMapping("/admin") 
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}
	
	@GetMapping("/login") 
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "index";
	}
}
