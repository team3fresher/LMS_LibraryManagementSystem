package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book_category_details")
public class BookCategoryDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_description")
	private String categoryDescription;

	// bi-directional many-to-one association to Book
	@OneToMany(mappedBy = "bookCategoryDetail", fetch = FetchType.LAZY)
	private List<Book> books;

	public BookCategoryDetail() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setBookCategoryDetail(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setBookCategoryDetail(null);

		return book;
	}

}