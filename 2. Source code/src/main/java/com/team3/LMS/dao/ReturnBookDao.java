package com.team3.LMS.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.ReturnBook;

@Repository
public interface ReturnBookDao extends CrudRepository<ReturnBook, Integer> {
	Page<ReturnBook> findAll(Pageable pageable);
}
