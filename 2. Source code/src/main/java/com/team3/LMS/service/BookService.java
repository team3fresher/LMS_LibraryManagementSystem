package com.team3.LMS.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.BookDao;
import com.team3.LMS.dao.PublisherDetailDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.LMS.dao.AuthorDetailDao;
import com.team3.LMS.dao.BookCategoryDetailDao;
import com.team3.LMS.dto.AuthorDetail;
import com.team3.LMS.dto.Book;
import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.dto.PublisherDetail;

import net.minidev.json.parser.JSONParser;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookCategoryDetailDao bookCategoryDetailDao;
	@Autowired
	private PublisherDetailDao publishDetailDao;
	@Autowired
	private AuthorDetailDao authorDetailDao;

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

	public void editBook(Map<String, Object> map, String isbn) {
		Book book = new Book();
		book.setIsbn(map.get("isbn").toString());
		book.setAmount((int) map.get("amount"));
		List<AuthorDetail> authorDetails = new ArrayList<AuthorDetail>();
		authorDetails = (List<AuthorDetail>) map.get("authorDetails");
		book.setAuthorDetails(authorDetails);
		BookCategoryDetail bookCategoryDetail = new BookCategoryDetail();
		HashMap hashMap = (HashMap) map.get("bookCategoryDetail");
		bookCategoryDetail.setCategoryId((int)hashMap.get("categoryId"));
		book.setBookCategoryDetail(bookCategoryDetailDao.findOne(bookCategoryDetail.getCategoryId()));
		book.setBrwTcktNber((int) map.get("brwTcktNber"));
		book.setImportance((int) map.get("importance"));
		book.setPublishingYear((int) map.get("publishingYear"));
		PublisherDetail publisherDetail = new PublisherDetail();
		hashMap = (HashMap) map.get("publisherDetail");
		publisherDetail.setPublisherId((int)hashMap.get("publisherId"));
		book.setPublisherDetail(publishDetailDao.findOne(publisherDetail.getPublisherId()));
		book.setShortDescription(map.get("shortDescription").toString());
		book.setTitle(map.get("title").toString());
		book.setValidStatus((byte) map.get("validStatus"));
		bookDao.save(book);
	}

	public void editBook(Object object, String isbn) {
		/*
		 * Book book = bookDao.findOne(map.get("isbn").toString());
		 * book.setTitle("test test test"); System.out.println("parse: " +
		 * map.get("bookCategoryDetail").toString());
		 * book.setBookCategoryDetail((BookCategoryDetail)
		 * map.get("bookCategoryDetail"));
		 */
		ObjectMapper mapper = new ObjectMapper();
		Book book = mapper.convertValue(object, Book.class);
		bookDao.save(book);
	}

	public void removeBook(String id) {
		bookDao.delete(id);
	}

	public Book getBook(String isbn) {
		return bookDao.findOne(isbn);
	}
}
