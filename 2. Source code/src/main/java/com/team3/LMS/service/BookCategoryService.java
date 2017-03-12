package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookCategoryDetailDao;
import com.team3.LMS.dto.BookCategoryDetail;


@Service
public class BookCategoryService {
	@Autowired
	private BookCategoryDetailDao bookCategoryDetailDao;

	public List<BookCategoryDetail> getCategoryList() {
		return (List<BookCategoryDetail>) bookCategoryDetailDao.findAll();
	}

	public Page<BookCategoryDetail> findAll(Pageable pageable) {
		return bookCategoryDetailDao.findAll(pageable);
	}

	public void addCategory(BookCategoryDetail bookCategory) {
		bookCategoryDetailDao.save(bookCategory);
	}

	public void removeCategory(int id) {
		bookCategoryDetailDao.delete(id);
	}

	public BookCategoryDetail getCategory(int id) {
		return bookCategoryDetailDao.findOne(id);
	}
}
