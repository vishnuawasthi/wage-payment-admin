package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "VIEW_EMPLOYEE_PAYMENT")
public class EmployeePayments {

	@Column(name = "PAYMENT_ID")
	private Long paymentId;

	@Column(name = "EMP_ID")
	private Long employeeId;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LAST_NAME")
	private String lastname;

	@Column(name = "DEBIT")
	private String debit;

	@Column(name = "CREDIT")
	private String credit;

	@Column(name = "CREATED_DT")
	private Date createdDate;

	@Column(name = "NOTE")
	private String note;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
