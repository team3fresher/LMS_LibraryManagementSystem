package com.team3.LMS.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.BookTestCategory;

@Repository
public interface BookTestCategoryDao extends CrudRepository<BookTestCategory, Integer> {

}
