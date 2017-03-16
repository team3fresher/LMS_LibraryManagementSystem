package com.team3.LMS.dto;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "return_book")
public class ReturnBook implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "return_book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnBookId;

	@Column(name = "fine")
	private int fine;

	@Temporal(TemporalType.DATE)
	@Column(name = "returned_date")
	private Date returnedDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Ticket ticket;

	public ReturnBook() {
	}

	public int getReturnBookId() {
		return this.returnBookId;
	}

	public void setReturnBookId(int returnBookId) {
		this.returnBookId = returnBookId;
	}

	public int getFine() {
		return this.fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public Date getReturnedDate() {
		return this.returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	@JsonIgnoreProperties({ "returnBooks" })
	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
