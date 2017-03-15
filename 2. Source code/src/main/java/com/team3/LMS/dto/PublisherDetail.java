package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publisher_details")
public class PublisherDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "publisher_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publisherId;

	@Column(name = "publisher_name")
	private String publisherName;

	// bi-directional many-to-one association to Book
	@OneToMany(mappedBy = "publisherDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books;

	public PublisherDetail() {
	}

	public int getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setPublisherDetail(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setPublisherDetail(null);

		return book;
	}

}