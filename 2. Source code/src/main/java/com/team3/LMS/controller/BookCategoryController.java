package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.service.BookCategoryService;

@RestController
@RequestMapping(value = "/category")
public class BookCategoryController {

	@Autowired
	BookCategoryService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<BookCategoryDetail>> getBookList() {
		List<BookCategoryDetail> categories = service.getCategoryList();
		if (categories.isEmpty()) {
			return new ResponseEntity<List<BookCategoryDetail>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BookCategoryDetail>>(categories, HttpStatus.OK);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public Page<BookCategoryDetail> findAll(Pageable pageable) {
		Page<BookCategoryDetail> categories = service.findAll(pageable);
		return categories;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addCategory(@RequestBody BookCategoryDetail BookCategory) {
		service.addCategory(BookCategory);
	}

	@RequestMapping("/remove/{id}")
	public void removeCategory(@PathVariable int id) {
		service.removeCategory(id);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BookCategoryDetail getCategory(@PathVariable int id) {
		return service.getCategory(id);
	}
}
