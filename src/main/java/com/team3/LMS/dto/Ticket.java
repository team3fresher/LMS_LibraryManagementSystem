package com.team3.LMS.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;

	@Column(name = "borrow_number")
	private int borrowNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "borrowed_date")
	private Date borrowedDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "expired_date")
	private Date expiredDate;

	@Column(name = "limition_number")
	private int limitionNumber;

	// bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "isbn")
	@JsonIgnore
	private Book book;

	// bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserInfo userInfo;

	public Ticket() {
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getBorrowNumber() {
		return this.borrowNumber;
	}

	public void setBorrowNumber(int borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public Date getBorrowedDate() {
		return this.borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public int getLimitionNumber() {
		return this.limitionNumber;
	}

	public void setLimitionNumber(int limitionNumber) {
		this.limitionNumber = limitionNumber;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}