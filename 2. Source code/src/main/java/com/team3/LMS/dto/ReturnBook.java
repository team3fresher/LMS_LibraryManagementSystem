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
	@Column(name = "return_date")
	private Date returnDate;

	// bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;

	public ReturnBook() {
	}

	public int getReturnBookId() {
		return returnBookId;
	}

	public void setReturnBookId(int returnBookId) {
		this.returnBookId = returnBookId;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
