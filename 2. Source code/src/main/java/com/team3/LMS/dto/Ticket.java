package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;

	@Column(name = "borrow_number")
	private int borrowNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "borrowed_date")
	private Date borrowedDate;

	@OneToMany(mappedBy = "ticket")
	private List<ReturnBook> returnBooks;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;

	@ManyToMany
	@JoinTable(name = "ticket_book", joinColumns = { @JoinColumn(name = "ticket_id") }, inverseJoinColumns = {
			@JoinColumn(name = "isbn") })
	private List<Book> books;

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
	
	public List<ReturnBook> getReturnBooks() {
		return this.returnBooks;
	}

	public void setReturnBooks(List<ReturnBook> returnBooks) {
		this.returnBooks = returnBooks;
	}

	public ReturnBook addReturnBook(ReturnBook returnBook) {
		getReturnBooks().add(returnBook);
		returnBook.setTicket(this);

		return returnBook;
	}

	public ReturnBook removeReturnBook(ReturnBook returnBook) {
		getReturnBooks().remove(returnBook);
		returnBook.setTicket(null);

		return returnBook;
	}
	
	@JsonIgnoreProperties({ "tickets" })
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@JsonIgnoreProperties({ "tickets" })
	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}