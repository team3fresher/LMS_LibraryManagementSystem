package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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

	// bi-directional many-to-many association to AuthorDetail
	@ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<AuthorDetail> authorDetails;

	// bi-directional many-to-one association to BookCategoryDetail
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private BookCategoryDetail bookCategoryDetail;

	// bi-directional many-to-one association to PublisherDetail
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private PublisherDetail publisherDetail;

	// bi-directional many-to-one association to TicketBookUser
	@OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<TicketBookUser> ticketBookUsers;

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBrwTcktNber() {
		return this.brwTcktNber;
	}

	public void setBrwTcktNber(int brwTcktNber) {
		this.brwTcktNber = brwTcktNber;
	}

	public int getImportance() {
		return this.importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getPublishingYear() {
		return this.publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getValidStatus() {
		return this.validStatus;
	}

	public void setValidStatus(byte validStatus) {
		this.validStatus = validStatus;
	}

	@JsonIgnore
	public List<AuthorDetail> getAuthorDetails() {
		return authorDetails;
	}

	public void setAuthorDetails(List<AuthorDetail> authorDetails) {
		this.authorDetails = authorDetails;
	}

	@JsonIgnore
	//@XmlTransient
	//@JsonInclude
	//@JsonIgnoreProperties({ "createdBy", "lastModifiedBy" })
	public BookCategoryDetail getBookCategoryDetail() {
		return this.bookCategoryDetail;
	}

	public void setBookCategoryDetail(BookCategoryDetail bookCategoryDetail) {
		this.bookCategoryDetail = bookCategoryDetail;
	}

	@JsonIgnore
	public PublisherDetail getPublisherDetail() {
		return this.publisherDetail;
	}

	public void setPublisherDetail(PublisherDetail publisherDetail) {
		this.publisherDetail = publisherDetail;
	}

	@JsonIgnore
	public List<TicketBookUser> getTicketBookUsers() {
		return this.ticketBookUsers;
	}

	public void setTicketBookUsers(List<TicketBookUser> ticketBookUsers) {
		this.ticketBookUsers = ticketBookUsers;
	}

	public TicketBookUser addTicketBookUser(TicketBookUser ticketBookUser) {
		getTicketBookUsers().add(ticketBookUser);
		ticketBookUser.setBook(this);

		return ticketBookUser;
	}

	public TicketBookUser removeTicketBookUser(TicketBookUser ticketBookUser) {
		getTicketBookUsers().remove(ticketBookUser);
		ticketBookUser.setBook(null);

		return ticketBookUser;
	}

}