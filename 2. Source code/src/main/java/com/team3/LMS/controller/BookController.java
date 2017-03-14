package com.team3.LMS.controller;

import java.util.List;
import java.util.Map;

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
import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getBookList() {
		return service.getBookList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<Book> findAll(Pageable pageable) {
		Page<Book> books = service.findAll(pageable);
		return books;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	@ResponseBody
	public List<BookCategoryDetail> getCategory() {
		return service.getBookCategoryDetail();
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void editBook(@RequestBody Map<String, Object> map, @PathVariable String id) {
		service.editBook(map, id);
	}
	
	@RequestMapping("/remove/{id}")
	public void removeBook(@PathVariable String id) {
		service.removeBook(id);
	}
	
	@RequestMapping(value = "/get/{isbn}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable String isbn) {
		return service.getBook(isbn);
	}
}
