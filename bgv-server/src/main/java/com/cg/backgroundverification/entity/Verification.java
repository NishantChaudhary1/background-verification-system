package com.cg.backgroundverification.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "verification_details")
public class Verification {

	@Id
	@GeneratedValue
	private int verfId;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public Verification() {
		super();
	}

	public Verification(Date startDate, Date endDate, String status) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}



	public int getVerfId() {
		return verfId;
	}

	public void setVerfId(int verfId) {
		this.verfId = verfId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
