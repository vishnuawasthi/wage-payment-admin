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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.validators.EmailId;

@Entity
@Table(name = "EMPLOYEE")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_EMPLOYEE", sequenceName = "SEQ_EMPLOYEE")
public class Employee extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
	@Column(name = "ID")
	private Long id;

	@NotEmpty(message = "First Name is required")
	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstname;

	@NotEmpty(message = "Last Name is required")
	@Column(name = "LAST_NAME", nullable = false, length = 100)
	private String lastname;

	@NotEmpty(message = "Email is required")
	@EmailId(regExp="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
	@Column(name = "EMAIL", nullable = false, length = 100)
	private String email;

	@Pattern(regexp = "^(?:[0-9]{10}|)$", message = "Contact number accepts only digit  of length 10")
	@NotEmpty(message = "Contact number is required")
	@Column(name = "CONTACT_NUMBER", length = 10)
	private String contactNumber;

	@NotEmpty(message = "AddressLine1 is required")
	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine1 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	@Column(name = "ADDRESS_LINE1", nullable = false, length = 100)
	private String addressLine1;

	@NotEmpty(message = "AddressLine2 is required")
	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine2 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	@Column(name = "ADDRESS_LINE2", nullable = true, length = 100)
	private String addressLine2;

	@NotEmpty(message = "Pincode is required")
	@Pattern(regexp = "^(?:[0-9]{6}|)$", message = "Pincode accepts only digits of length 6")
	@Column(name = "PINCODE", nullable = false, length = 6)
	private String pincode;

	@NotEmpty(message = "State is required")
	@Column(name = "ST_CD", nullable = false, length =6)
	private String stateCode;

	@NotEmpty(message = "Coutry is required")
	@Column(name = "COUNTRY_CD", nullable = false, length = 6)
	private String countryCode;
	
	@Transient
	@NotEmpty(message = "Client Name is required")
	private String clientCode;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private ClientConfig clientConfig;

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

	public ClientConfig getClientConfig() {
		return clientConfig;
	}

	public void setClientConfig(ClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", pincode=" + pincode + ", stateCode=" + stateCode + ", countryCode=" + countryCode
				+ ", clientCode=" + clientCode + ", clientConfig=" + clientConfig + "]";
	}

	
	
}
