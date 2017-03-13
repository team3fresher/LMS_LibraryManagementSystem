package com.team3.LMS.controller;

import java.time.Year;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dao.*;
import com.team3.LMS.dto.*;

@RestController
public class TestController {
	@Autowired
	public BookDao bookDao;
	@Autowired
	public AuthorDetailDao authorDetailDao;
	@Autowired
	public BookCategoryDetailDao bookCategoryDetailDao;
	@Autowired
	public TicketBookUserDao ticketBookUserDao;
	@Autowired
	public PublisherDetailDao publisherDetailDao;

	@RequestMapping(value = "/listbook", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getListBook() {
		List<Book> temp = (List<Book>) bookDao.findAll();
		return temp;
	}

	@RequestMapping(value = "/strbook", method = RequestMethod.GET)
	@ResponseBody
	public String getStrBook() {
		List<Book> temp = (List<Book>) bookDao.findAll();
		return temp.toString();
	}

	/*@RequestMapping(value = "/addBookToBookCategory", method = RequestMethod.GET)
	@ResponseBody
	public String getBookInfo() {
		BookTestCategory categoryA = new BookTestCategory("Category A");
		Set bookAs = new HashSet<BookTest>() {
			{
				add(new BookTest("Book A1", categoryA));
				add(new BookTest("Book A2", categoryA));
				add(new BookTest("Book A3", categoryA));
			}
		};
		categoryA.setBooks(bookAs);
		bookTestCategoryDao.save(categoryA);
		String temp = bookTestCategoryDao.findAll().toString();
		return temp;
	}*/

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	@ResponseBody
	public String addBook() {
		List<Book> books = (List<Book>) bookDao.findAll();
		Book add = new Book();
		add.setIsbn("1234567");
		add.setAmount(1);
		add.setAuthorDetails((List<AuthorDetail>) authorDetailDao.findAll());
		add.setBookCategoryDetail(bookCategoryDetailDao.findOne(1));
		add.setBrwTcktNber(1);
		add.setImportance(1);
		add.setPublishingYear(1997);
		add.setPublisherDetail(publisherDetailDao.findOne(1));
		add.setShortDescription("test");
		add.setTitle("test");
		add.setValidStatus((byte) 1);
		//add.setTicketBookUsers((List<TicketBookUser>) ticketBookUserDao.findAll());
		
		bookDao.save(add);
		return books.toString();
	}
}
