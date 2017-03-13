package com.team3.LMS.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TicketBookUserPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "isbn", insertable = false, updatable = false)
	private String isbn;

	@Column(name = "user_id", insertable = false, updatable = false)
	private int userId;

	@Column(name = "ticket_id", insertable = false, updatable = false)
	private int ticketId;

	public TicketBookUserPK() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TicketBookUserPK)) {
			return false;
		}
		TicketBookUserPK castOther = (TicketBookUserPK) other;
		return this.isbn.equals(castOther.isbn) && (this.userId == castOther.userId)
				&& (this.ticketId == castOther.ticketId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.isbn.hashCode();
		hash = hash * prime + this.userId;
		hash = hash * prime + this.ticketId;

		return hash;
	}
}