package com.team3.LMS.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author_details database table.
 * 
 */
@Entity
@Table(name="author_details")
public class AuthorDetail {

	@Id
	@Column(name="author_id")
	private int authorId;

	@Column(name="author_name")
	private String authorName;

	//bi-directional many-to-many association to Book
	@ManyToMany
	@JoinTable(
		name="book_author"
		, joinColumns={
			@JoinColumn(name="author_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="isbn")
			}
		)
	private List<Book> books;

	public AuthorDetail() {
	}

	public int getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}