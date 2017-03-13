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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the user_info database table.
 * 
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String address;

	private String degree;

	private String email;

	private String job;

	@Column(name = "phone_number")
	private int phoneNumber;

	private String pword;

	@Column(name = "real_name")
	private String realName;

	private String sex;
	
	private boolean valid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dayofbirth")
	private Date dayOfBirth;

	// bi-directional many-to-one association to Payment
	@OneToMany(mappedBy = "userInfo")
	private List<Payment> payments;

	// bi-directional many-to-one association to ReturnBook
	@OneToMany(mappedBy = "userInfo")
	private List<ReturnBook> returnBooks;

	// bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	// bi-directional many-to-one association to TicketBookUser
	@OneToMany(mappedBy = "userInfo")
	private List<TicketBookUser> ticketBookUsers;

	public UserInfo() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPword() {
		return this.pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}	
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	@JsonIgnore
	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setUserInfo(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setUserInfo(null);

		return payment;
	}

	@JsonIgnore
	public List<ReturnBook> getReturnBooks() {
		return this.returnBooks;
	}

	public void setReturnBooks(List<ReturnBook> returnBooks) {
		this.returnBooks = returnBooks;
	}

	public ReturnBook addReturnBook(ReturnBook returnBook) {
		getReturnBooks().add(returnBook);
		returnBook.setUserInfo(this);

		return returnBook;
	}

	public ReturnBook removeReturnBook(ReturnBook returnBook) {
		getReturnBooks().remove(returnBook);
		returnBook.setUserInfo(null);

		return returnBook;
	}

	@JsonIgnore
	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
		ticketBookUser.setUserInfo(this);

		return ticketBookUser;
	}

	public TicketBookUser removeTicketBookUser(TicketBookUser ticketBookUser) {
		getTicketBookUsers().remove(ticketBookUser);
		ticketBookUser.setUserInfo(null);

		return ticketBookUser;
	}

}