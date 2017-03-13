package com.team3.LMS.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "staff_info")
public class StaffInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "staff_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;

	private String address;

	private String degree;

	private String email;

	@Column(name = "phone_number")
	private int phoneNumber;

	private int pword;

	@Column(name = "real_name")
	private String realName;

	private String sex;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dayofbirth")
	private Date dayOfBirth;

	public StaffInfo() {
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPword() {
		return this.pword;
	}

	public void setPword(int pword) {
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

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
}