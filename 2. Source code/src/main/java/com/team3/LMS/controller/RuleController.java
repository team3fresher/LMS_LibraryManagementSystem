package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dto.Rule;
import com.team3.LMS.service.RuleService;

@RestController
@RequestMapping(value = "/rule")
public class RuleController {
	
	@Autowired
	RuleService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Rule> getRuleList(){
		return service.getRuleList();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)	
	public void addRule(@RequestBody Rule rule){
		service.addRule(rule);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)	
	public void addRule(@PathVariable int id){
		service.removeRule(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)	
	public Rule getRule(@PathVariable int id){
		return service.getRule(id);
	}
	
	@RequestMapping(value = "/limit", method = RequestMethod.GET)
	@ResponseBody
	public int getLimit(){
		return service.getLimit();
	}
	
	@RequestMapping(value = "/limitUpdate", method = RequestMethod.POST)	
	public void updateLimit(@RequestBody int newValue){
		service.updateLimit(newValue);
	}
}
