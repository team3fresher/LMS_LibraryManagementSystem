package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookDao;
import com.team3.LMS.dto.AuthorDetail;
import com.team3.LMS.dto.Book;
import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.dto.PublisherDetail;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	public List<Book> getBookList() {
		return (List<Book>) bookDao.findAll();
	}
	
	public List<BookCategoryDetail> getBookCategoryDetail() {
		return bookDao.findBookCategoryDetail();
	}

	public Page<Book> findAll(Pageable pageable) {
		return bookDao.findAll(pageable);
	}

	public void addBook(Book book) {
		bookDao.save(book);
	}
	
	public void editBook(Book book) {
		BookCategoryDetail bookCategoryDetail = book.getBookCategoryDetail();
		PublisherDetail publisherDetail = book.getPublisherDetail();
		List<AuthorDetail> list = book.getAuthorDetails();
		book.setAuthorDetails(list);
		bookDao.save(book);
	}

	public void removeBook(String id) {
		bookDao.delete(id);
	}

	public Book getBook(String isbn) {
		return bookDao.findOne(isbn);
	}
}
