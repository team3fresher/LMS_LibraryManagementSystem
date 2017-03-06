package com.team3.LMS.dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staff_info database table.
 * 
 */
@Entity
@Table(name="staff_info")
@NamedQuery(name="StaffInfo.findAll", query="SELECT s FROM StaffInfo s")
public class StaffInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="staff_id")
	private int staffId;

	private int pword;

	@Column(name="staff_name")
	private String staffName;

	public StaffInfo() {
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getPword() {
		return this.pword;
	}

	public void setPword(int pword) {
		this.pword = pword;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

}