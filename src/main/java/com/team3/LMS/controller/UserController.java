package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dto.User;
import com.team3.LMS.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService service;
    
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUser(){
    	List<User> users = (List<User>) service.findAll();
        return users;
    }
}
