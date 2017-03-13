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
@Table(name = "payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;

	private int fine;

	@Temporal(TemporalType.DATE)
	@Column(name = "pay_day")
	private Date payDay;

	@Column(name = "payment_amount")
	private int paymentAmount;

	// bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getFine() {
		return this.fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public Date getPayDay() {
		return this.payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	public int getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}