package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "author_details")
public class AuthorDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;

	@Column(name = "author_name")
	private String authorName;

	// bi-directional many-to-many association to Book
	@ManyToMany(mappedBy = "authorDetails")
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