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

import com.team3.LMS.dto.Book;
import com.team3.LMS.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getBookList() {
		return service.getBookList();
	}

	@RequestMapping(value = "/book/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<Book> findAll(Pageable pageable) {
		Page<Book> books = service.findAll(pageable);
		return books;
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public void addProduct(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@RequestMapping("/book/remove/{id}")
	public void removeBook(@PathVariable int id) {
		service.removeBook(id);
	}
	
	@RequestMapping(value = "/book/get/{isbn}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable int isbn) {
		return service.getBook(isbn);
	}
}
