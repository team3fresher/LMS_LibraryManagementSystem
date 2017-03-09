package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookCategoryDao;
import com.team3.LMS.dto.BookCategoryDetail;

@Service
public class BookCategoryService {
	@Autowired
	private BookCategoryDao bookCategoryDao;

	public List<BookCategoryDetail> getCategoryList() {
		return (List<BookCategoryDetail>) bookCategoryDao.findAll();
	}

	public Page<BookCategoryDetail> findAll(Pageable pageable) {
		return bookCategoryDao.findAll(pageable);
	}

	public void addCategory(BookCategoryDetail bookCategory) {
		bookCategoryDao.save(bookCategory);
	}

	public void removeCategory(int id) {
		bookCategoryDao.delete(id);
	}

	public BookCategoryDetail getCategory(int id) {
		return bookCategoryDao.findOne(id);
	}
}
