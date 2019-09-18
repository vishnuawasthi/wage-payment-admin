package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_CONFIG")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_PAYMENT", sequenceName = "SEQ_PAYMENT")
public class Payment extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAYMENT")
	@Column(name = "ID")
	private Long id;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "CR")
	private String credited;

	@Column(name = "DR")
	private String debited;

	@Column(name = "NOTE")
	private String note;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCredited() {
		return credited;
	}

	public void setCredited(String credited) {
		this.credited = credited;
	}

	public String getDebited() {
		return debited;
	}

	public void setDebited(String debited) {
		this.debited = debited;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", credited=" + credited + ", debited=" + debited
				+ ", note=" + note + ", employee=" + employee + "]";
	}

}
