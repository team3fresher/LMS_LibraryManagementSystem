package com.team3.LMS.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_book_category")
public class BookTestCategory {
	private int id;
	private String name;
	private Set<BookTest> books;

	public BookTestCategory() {

	}

	public BookTestCategory(String name) {
		this.name = name;
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

	@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
	public Set<BookTest> getBooks() {
		return books;
	}

	public void setBooks(Set<BookTest> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		String result = String.format("Category[id=%d, name='%s']%n", id, name);
		if (books != null) {
			for (BookTest book : books) {
				result += String.format("Book[id=%d, name='%s']%n", book.getId(), book.getName());
			}
		}

		return result;
	}
}