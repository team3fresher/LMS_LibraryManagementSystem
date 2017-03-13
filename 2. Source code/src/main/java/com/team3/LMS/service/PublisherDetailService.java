package com.team3.LMS.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.PublisherDetailDao;
import com.team3.LMS.dto.PublisherDetail;

@Service
public class PublisherDetailService {
	@Autowired
	private PublisherDetailDao publisherDetailDao;

	public List<PublisherDetail> getPublisherDetailList() {
		return (List<PublisherDetail>) publisherDetailDao.findAll();
	}

	public Page<PublisherDetail> findAll(Pageable pageable) {
		return publisherDetailDao.findAll(pageable);
	}

	public void addPublisherDetail(PublisherDetail publisherDetail) {
		publisherDetailDao.save(publisherDetail);
	}

	public void removePublisherDetail(Integer id) {
		publisherDetailDao.delete(id);
	}

	public PublisherDetail getPublisherDetail(Integer id) {
		return  publisherDetailDao.findOne(id);
	}
}
