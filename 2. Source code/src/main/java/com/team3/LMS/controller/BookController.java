package com.team3.LMS.controller;

import java.util.ArrayList;
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
import com.team3.LMS.dto.Book;
import com.team3.LMS.service.AuthorDetailService;
import com.team3.LMS.service.BookCategoryService;
import com.team3.LMS.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookService service;
	@Autowired
	AuthorDetailService authorService;
	@Autowired
	BookCategoryService bookCategoryService;

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

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public void editBook(@RequestBody Book book) {
		service.addBook(book);
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

	@RequestMapping(value = "/check/{isbn}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkISBN(@PathVariable String isbn) {
		return service.checkISBN(isbn);
	}
}
