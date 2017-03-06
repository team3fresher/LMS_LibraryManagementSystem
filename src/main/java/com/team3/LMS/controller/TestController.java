package com.team3.LMS.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public TestDao userDao;
	@Autowired
	public StaffInfoDao staffDao;
	@Autowired
	public BookTestDao bookdao;
	@Autowired
	public BookTestCategoryDao bookCategoryDao;

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
		bookCategoryDao.save(categoryA);
		String temp = bookCategoryDao.findAll().toString();
		return temp;
	}
}
