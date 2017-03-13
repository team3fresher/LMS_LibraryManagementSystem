package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.LMS.dto.AuthorDetail;
import com.team3.LMS.service.AuthorDetailService;

@Controller
@RequestMapping(value = "/author")
public class AuthorDetailController {

	@Autowired
	AuthorDetailService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<AuthorDetail> getTicketList() {
		return service.getAuthorDetailList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<AuthorDetail> findAll(Pageable pageable) {
		Page<AuthorDetail> tickets = service.findAll(pageable);
		return tickets;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addAuthorDetail(@RequestBody AuthorDetail authorDetail) {
		service.addAuthorDetail(authorDetail);
	}
	
	@RequestMapping("/remove/{id}")
	public void removeAuthorDetail(@PathVariable int id) {
		service.removeAuthorDetail(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AuthorDetail getAuthorDetail(@PathVariable int id) {
		return service.getAuthorDetail(id);
	}
}
