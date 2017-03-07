package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookDao;
import com.team3.LMS.dto.Book;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	public List<Book> getBookList() {
		return (List<Book>) bookDao.findAll();
	}

	public Page<Book> findAll(Pageable pageable) {
		return bookDao.findAll(pageable);
	}

	public void addBook(Book book) {
		bookDao.save(book);
	}

	public void removeBook(int id) {
		bookDao.delete(id);
	}

	public Book getBook(int isbn) {
		return bookDao.findOne(isbn);
	}
}
