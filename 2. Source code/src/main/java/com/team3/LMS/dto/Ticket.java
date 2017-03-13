package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "expired_date")
	private Date expiredDate;
	
	@Column(name = "limition_number", nullable = false)
	private int limitionNumber;

	// bi-directional many-to-one association to TicketBookUser
	@OneToMany(mappedBy = "ticket")
	private List<TicketBookUser> ticketBookUsers;

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

	public List<TicketBookUser> getTicketBookUsers() {
		return this.ticketBookUsers;
	}

	public void setTicketBookUsers(List<TicketBookUser> ticketBookUsers) {
		this.ticketBookUsers = ticketBookUsers;
	}

	public TicketBookUser addTicketBookUser(TicketBookUser ticketBookUser) {
		getTicketBookUsers().add(ticketBookUser);
		ticketBookUser.setTicket(this);

		return ticketBookUser;
	}

	public TicketBookUser removeTicketBookUser(TicketBookUser ticketBookUser) {
		getTicketBookUsers().remove(ticketBookUser);
		ticketBookUser.setTicket(null);

		return ticketBookUser;
	}

}