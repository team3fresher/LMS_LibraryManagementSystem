package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.ReturnBookDao;
import com.team3.LMS.dto.ReturnBook;

@Service
public class ReturnBookService {
	@Autowired
	private ReturnBookDao returnBookDao;

	public List<ReturnBook> getReturnBookList() {
		return (List<ReturnBook>) returnBookDao.findAll();
	}

	public Page<ReturnBook> findAll(Pageable pageable) {
		return returnBookDao.findAll(pageable);
	}

	public void addReturnBook(ReturnBook returnBook) {
		returnBookDao.save(returnBook);
	}

	public void removeReturnBook(int id) {
		returnBookDao.delete(id);
	}

	public ReturnBook getReturnBook(int id) {
		return returnBookDao.findOne(id);
	}
}
