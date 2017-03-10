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
	private float isbn;

	private int amount;

	@Column(name="brw_tckt_nber")
	private int brwTcktNber;

	private int importance;

	@Column(name="publishing_year")
	private Date publishingYear;

	@Column(name="short_description")
	private String shortDescription;

	private String title;

	@Column(name="valid_status")
	private byte validStatus;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private BookCategoryDetail bookCategoryDetail;
	
	@ManyToOne
	@JoinColumn(name="publisher_id")
	private PublisherDetail publisherDetail;

	public Book() {
	}

	public float getIsbn() {
		return isbn;
	}

	public void setIsbn(float isbn) {
		this.isbn = isbn;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBrwTcktNber() {
		return brwTcktNber;
	}

	public void setBrwTcktNber(int brwTcktNber) {
		this.brwTcktNber = brwTcktNber;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public Object getPublishingYear() {
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
	public BookCategoryDetail getBookCategory() {
		return bookCategoryDetail;
	}

	public void setBookCategory(BookCategoryDetail bookCategoryDetail) {
		this.bookCategoryDetail = bookCategoryDetail;
	}
	
	@JsonIgnore
	public PublisherDetail getPublisherDetail() {
		return publisherDetail;
	}

	public void setPublisherDetail(PublisherDetail publisherDetail) {
		this.publisherDetail = publisherDetail;
	}
}