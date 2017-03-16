package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn")
	private String isbn;

	@Column(name = "amount")
	private int amount;

	@Column(name = "brw_tckt_nber")
	private int brwTcktNber;

	@Column(name = "importance")
	private int importance;

	// @Temporal(TemporalType.DATE)
	@Column(name = "publishing_year")
	private int publishingYear;

	@Column(name = "short_description")
	private String shortDescription;

	private String title;

	@Column(name = "valid_status")
	private byte validStatus;

	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn"), inverseJoinColumns = @JoinColumn(name = "authorId", referencedColumnName = "author_id"))
	private List<AuthorDetail> authorDetails;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private BookCategoryDetail bookCategoryDetail;

	@ManyToOne(optional = false)
	@JoinColumn(name = "publisher_id")
	private PublisherDetail publisherDetail;

	@ManyToOne
	@JoinColumn(name = "rule_id")
	private Rule rule;

	@ManyToMany(mappedBy = "books")
	private List<Ticket> tickets;

	public Book() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
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
	
	@JsonIgnoreProperties({ "books" })
	public List<AuthorDetail> getAuthorDetails() {
		return authorDetails;
	}

	public void setAuthorDetails(List<AuthorDetail> authorDetails) {
		this.authorDetails = authorDetails;
	}
	
	@JsonIgnoreProperties({ "books" })
	public BookCategoryDetail getBookCategoryDetail() {
		return bookCategoryDetail;
	}

	public void setBookCategoryDetail(BookCategoryDetail bookCategoryDetail) {
		this.bookCategoryDetail = bookCategoryDetail;
	}
	
	@JsonIgnoreProperties({ "books" })
	public PublisherDetail getPublisherDetail() {
		return publisherDetail;
	}
	
	public void setPublisherDetail(PublisherDetail publisherDetail) {
		this.publisherDetail = publisherDetail;
	}
	
	@JsonIgnoreProperties({ "books" })
	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	@JsonIgnoreProperties({ "books" })
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}