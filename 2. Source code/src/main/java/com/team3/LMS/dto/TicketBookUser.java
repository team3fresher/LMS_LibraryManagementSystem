package com.team3.LMS.dto;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket_book_user")
public class TicketBookUser implements Serializable {

	@EmbeddedId
	private TicketBookUserPK id;

	// bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name = "isbn", insertable=false, updatable=false)
	private Book book;

	// bi-directional many-to-one association to Ticket
	@ManyToOne
	@JoinColumn(name = "ticket_id", insertable=false, updatable=false)
	private Ticket ticket;

	// bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name = "user_id", insertable=false, updatable=false)
	private UserInfo userInfo;

	public TicketBookUser() {
	}
	
	public TicketBookUserPK getId() {
		return this.id;
	}

	public void setId(TicketBookUserPK id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}