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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE")

@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE")
public class Employee extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
	@Column(name = "ID")
	private Long id;

	@NotNull(message = "First Name is required")
	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstname;

	@NotNull(message = "Last Name is required")
	@Column(name = "LAST_NAME", nullable = false, length = 100)
	private String lastname;

	@NotNull(message = "Middle Name is required")
	@Column(name = "MIDDLE_NAME", nullable = true, length = 100)
	private String middlename;

	@NotNull(message = "AddressLine1 is required")
	@Column(name = "ADDRESS_LINE1", nullable = false, length = 100)
	private String addressLine1;

	@NotNull(message = "AddressLine2 is required")
	@Column(name = "ADDRESS_LINE2", nullable = true, length = 100)
	private String addressLine2;

	@NotNull(message = "Pincode is required")
	@Column(name = "PINCODE", nullable = false, length = 6)
	private String pincode;

/*	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private ClientConfig clientConfig;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
}
