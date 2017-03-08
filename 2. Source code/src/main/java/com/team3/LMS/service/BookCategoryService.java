package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookCategoryDao;
import com.team3.LMS.dto.BookCategory;

@Service
public class BookCategoryService {
	@Autowired
	private BookCategoryDao bookCategoryDao;

	public List<BookCategory> getCategoryList() {
		return (List<BookCategory>) bookCategoryDao.findAll();
	}

	public Page<BookCategory> findAll(Pageable pageable) {
		return bookCategoryDao.findAll(pageable);
	}

	public void addCategory(BookCategory bookCategory) {
		bookCategoryDao.save(bookCategory);
	}

	public void removeCategory(int id) {
		bookCategoryDao.delete(id);
	}

	public BookCategory getCategory(int id) {
		return bookCategoryDao.findOne(id);
	}
}
