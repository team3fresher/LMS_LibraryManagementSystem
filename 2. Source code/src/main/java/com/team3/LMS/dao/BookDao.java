package com.team3.LMS.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.Book;
import com.team3.LMS.dto.BookCategoryDetail;

@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, String> {
	Page<Book> findAll(Pageable pageable);
	/*@Query("select a.isbn, a.bookCategoryDetail.categoryId from Book as a")
	List<Book> findAllData();*/
	@Query("select b.categoryId, b.categoryName, b.categoryDescription from Book as a, BookCategoryDetail as b where b.categoryId = a.bookCategoryDetail.categoryId")
	List<BookCategoryDetail> findBookCategoryDetail();
}
