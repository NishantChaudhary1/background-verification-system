package com.cg.backgroundverification.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document_details")
public class EmployeeDocument {

	@Id
	@GeneratedValue
	private int docId;
	private String docType;
	private int empId;
	private String empName;
	@Lob
	private byte[] docData;
	@OneToOne
	@JoinColumn(name = "verfId")
	Verification verificationdto;

	public Verification getVerificationdto() {
		return verificationdto;
	}

	public void setVerificationdto(Verification verificationdto) {
		this.verificationdto = verificationdto;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getDocData() {
		return docData;
	}

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}

	@Override
	public String toString() {
		return "EmployeeDocument [empId=" + empId + ", empName=" + empName + ", docId=" + docId + ", docType=" + docType
				+ ", docData=" + Arrays.toString(docData) + ", verificationdto=" + verificationdto + "]";
	}

	
}
