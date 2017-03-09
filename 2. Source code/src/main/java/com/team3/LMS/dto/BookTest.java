package com.team3.LMS.dto;

import javax.persistence.*;

@Entity
@Table(name = "test_book")
public class BookTest {
	private int id;
	private String name;
	private BookTestCategory bookCategory;

	public BookTest() {

	}

	public BookTest(String name) {
		this.name = name;
	}

	public BookTest(String name, BookTestCategory bookCategory) {
		this.name = name;
		this.bookCategory = bookCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "book_category_id")
	public BookTestCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookTestCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
}