package com.team3.LMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dto.UserInfo;
import com.team3.LMS.service.UserInfoService;

@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

	@Autowired
	UserInfoService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<UserInfo> getUserInfoList() {
		return service.getUserInfoList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserInfo> findAll(Pageable pageable) {
		Page<UserInfo> userInfos = service.findAll(pageable);
		return userInfos;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUserInfo(@RequestBody UserInfo userInfo) {
		service.addUserInfo(userInfo);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editUserInfo(@RequestBody UserInfo userInfo) {
		//userInfo.setUserId(id);
		service.addUserInfo(userInfo);
	}
	
	@RequestMapping("/remove/{id}")
	public void removeUserInfo(@PathVariable int id) {
		service.removeUserInfo(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfo(@PathVariable int id) {
		return service.getUserInfo(id);
	}

	@RequestMapping(value = "/userDetail")
	@ResponseBody
    public UserInfo getUserDetail()
    { 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		System.out.println("username: " + auth.getName());
		return service.findByEmail(auth.getName());
    } 

	@RequestMapping(value = "/getTotalUser", method = RequestMethod.GET)
	@ResponseBody
	public List<Integer> getTotalUser() {
		List<Integer> result = new ArrayList<Integer>();;
		result.add(service.getTotalUser());
		result.add(service.getTotalMale());
		result.add(service.getTotalFemale());
		return result;
	}

}
