package com.team3.LMS.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")
public class Book {
	@Id
	private int isbn;

	private int amount;

	private String author;

	@Column(name = "brw_tckt_nber")
	private int brwTcktNber;

	@Temporal(TemporalType.DATE)
	@Column(name = "publishing_year")
	private Date publishingYear;

	@Column(name = "short_description")
	private String shortDescription;

	private String title;

	@Column(name = "valid_status")
	private byte validStatus;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private BookCategory bookCategory;

	public Book() {
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBrwTcktNber() {
		return brwTcktNber;
	}

	public void setBrwTcktNber(int brwTcktNber) {
		this.brwTcktNber = brwTcktNber;
	}

	public Date getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Date publishingYear) {
		this.publishingYear = publishingYear;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(byte validStatus) {
		this.validStatus = validStatus;
	}

	@JsonIgnore
	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
}