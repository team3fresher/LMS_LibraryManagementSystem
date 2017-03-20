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

import com.team3.LMS.dto.ReturnBook;
import com.team3.LMS.service.ReturnBookService;

@Controller
@RequestMapping(value = "/returnBook")
public class ReturnBookController {

	@Autowired
	ReturnBookService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<ReturnBook> getReturnBookList() {
		return service.getReturnBookList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<ReturnBook> findAll(Pageable pageable) {
		Page<ReturnBook> returnBooks = service.findAll(pageable);
		return returnBooks;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addReturnBook(@RequestBody ReturnBook returnBook) {
		service.addReturnBook(returnBook);
	}
	
	@RequestMapping("/remove/{id}")
	public void removeReturnBook(@PathVariable int id) {
		service.removeReturnBook(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnBook getReturnBook(@PathVariable int id) {
		return service.getReturnBook(id);
	}
}
