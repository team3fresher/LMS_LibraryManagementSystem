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

import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.service.BookCategoryService;

@Controller
public class BookCategoryController {

	@Autowired
	BookCategoryService service;

	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	@ResponseBody
	public List<BookCategoryDetail> getBookList() {
		return service.getCategoryList();
	}

	@RequestMapping("/category/findAll")
	@ResponseBody
	public Page<BookCategoryDetail> findAll(Pageable pageable) {
		Page<BookCategoryDetail> categories = service.findAll(pageable);
		return categories;
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public void addCategory(@RequestBody BookCategoryDetail BookCategory) {
		service.addCategory(BookCategory);
	}

	@RequestMapping("/category/remove/{id}")
	public void removeCategory(@PathVariable int id) {
		service.removeCategory(id);
	}

	@RequestMapping(value = "/category/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BookCategoryDetail getCategory(@PathVariable int id) {
		return service.getCategory(id);
	}
}
