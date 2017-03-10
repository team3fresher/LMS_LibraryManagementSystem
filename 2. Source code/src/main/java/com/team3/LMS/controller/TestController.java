/*package com.team3.LMS.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.LMS.dao.BookCategoryDao;
import com.team3.LMS.dao.BookDao;
import com.team3.LMS.dao.BookTestCategoryDao;
import com.team3.LMS.dao.BookTestDao;
import com.team3.LMS.dao.StaffInfoDao;
import com.team3.LMS.dao.TestDao;
import com.team3.LMS.dto.Book;
import com.team3.LMS.dto.BookCategoryDetail;
import com.team3.LMS.dto.BookTest;
import com.team3.LMS.dto.BookTestCategory;
import com.team3.LMS.dto.StaffInfo;
import com.team3.LMS.dto.Test;

@RestController
public class TestController {

	@Autowired
	public TestDao userDao;
	@Autowired
	public StaffInfoDao staffDao;
	@Autowired
	public BookTestDao bookTestDao;
	@Autowired
	public BookTestCategoryDao bookTestCategoryDao;
	@Autowired
	public BookDao bookDao;
	@Autowired
	public BookCategoryDao bookCategoryDao;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public List<Test> getUser() {
		List<Test> users = (List<Test>) userDao.findAll();
		return users;
	}

	@RequestMapping(value = "/staff", method = RequestMethod.GET)
	@ResponseBody
	public List<StaffInfo> getStaffInfo() {
		List<StaffInfo> staffs = (List<StaffInfo>) staffDao.findAll();
		return staffs;
	}

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

	@RequestMapping(value = "/addBookToBookCategory", method = RequestMethod.GET)
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
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	@ResponseBody
	public String addBook() {
		BookCategoryDetail bookCategory = bookCategoryDao.findOne(1);
		List<Book> books = (List<Book>) bookDao.findAll();
		Book add = new Book();
		add.setIsbn(1234567);
		add.setAmount(123);
		add.setAuthor("author");
		add.setBrwTcktNber(3);
		add.setPublishingYear(new Date());
		add.setShortDescription("short");
		add.setTitle("Book 1");
		add.setValidStatus((byte) 1);
		add.setBookCategory(bookCategory);

		bookDao.save(add);
		return books.toString();
	}
}
*/