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
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dto.PublisherDetail;
import com.team3.LMS.service.PublisherDetailService;

@RestController
@RequestMapping(value = "/publisher")
public class PublisherDetailController {

	@Autowired
	PublisherDetailService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<PublisherDetail> getTicketList() {
		return service.getPublisherDetailList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<PublisherDetail> findAll(Pageable pageable) {
		Page<PublisherDetail> publishers = service.findAll(pageable);
		return publishers;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addPublisherDetail(@RequestBody PublisherDetail publisherDetail) {
		service.addPublisherDetail(publisherDetail);
	}
	
	@RequestMapping("/remove/{id}")
	public void removePublisherDetail(@PathVariable int id) {
		service.removePublisherDetail(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PublisherDetail getPublisherDetail(@PathVariable int id) {
		return service.getPublisherDetail(id);
	}
}
