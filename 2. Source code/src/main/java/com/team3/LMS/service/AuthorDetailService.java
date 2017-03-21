package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.AuthorDetailDao;
import com.team3.LMS.dto.AuthorDetail;

@Service
public class AuthorDetailService {
	@Autowired
	private AuthorDetailDao authorDetailDao;

	public List<AuthorDetail> getAuthorDetailList() {
		return (List<AuthorDetail>) authorDetailDao.findAll();
	}

	public Page<AuthorDetail> findAll(Pageable pageable) {
		return authorDetailDao.findAll(pageable);
	}

	public void addAuthorDetail(AuthorDetail authorDetail) {
		authorDetailDao.save(authorDetail);
	}

	public void removeAuthorDetail(Integer id) {
		authorDetailDao.delete(id);
	}

	public AuthorDetail getAuthorDetail(Integer id) {
		return  authorDetailDao.findOne(id);
	}
}
