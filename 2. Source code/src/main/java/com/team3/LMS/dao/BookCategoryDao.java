package com.team3.LMS.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.BookCategory;

@Repository
public interface BookCategoryDao extends CrudRepository<BookCategory, Integer> {
	Page<BookCategory> findAll(Pageable pageable);
}
