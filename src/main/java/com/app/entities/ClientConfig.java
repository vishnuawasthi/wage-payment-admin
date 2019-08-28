package com.app.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CLIENT_CONFIG")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_CLIENT_CONFIG", sequenceName = "SEQ_CLIENT_CONFIG")
public class ClientConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_CONFIG")
	@Column(name = "ID")
	private Long id;

	@NotEmpty(message = "Client name is required")
	//@Max(value = 100, message = "Maximum allowed character lenth is 100")
	@Column(name = "CLIENT_NAME", nullable = false)
	private String clientName;

	@Email(message = "Please enter valid email")
//	@Max(value = 100, message = "Maximum allowed character lenth is 100")
	@Column(name = "EMAIL", nullable = false)
	private String email;

	//@Max(value = 10, message = "Altername number can not be more than 12 digits")
	@NotEmpty(message = "Contact number is required")
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "ALT_CONTACT_NBR")
	//@Max(value = 10, message = "Altername number can not be more than 10 digits")
	private String alternameNumber;

	@NotEmpty(message = "Client Code is required")
	@Column(name = "CLIENT_CODE", nullable = false, unique = true)
	private String clientCode;

	@NotEmpty(message = "Registration number is required")
	@Column(name = "REG_NBR")
	private String registrationNumber;

	@Column(name = "ONBOARD_DT")
	private Date onboardDate;

	@Column(name = "LIVE_DT")
	private Date liveDate;

	@NotEmpty(message = "Client type is required")
	@Column(name = "CLIENT_TYPE")
	private String clientType;

	@NotEmpty(message = "Address line1 is required")
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@NotEmpty(message = "Pincode is required")
	@Column(name = "PINCODE")
	//@Max(value = 6, message = "Pincode can not be more than 6 digits long")
	private String pincode;

	@NotEmpty(message = "State code is required")
	@Column(name = "ST_CD")
	private String stateCode;

	@NotEmpty(message = "Coutry code is required")
	@Column(name = "COUNTRY_CD")
	private String coutryCode;

	/*
	 * @OneToMany(mappedBy = "clientConfig") private Set<Employee> employees = new
	 * HashSet<Employee>();
	 */

	public ClientConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public String getAlternameNumber() {
		return alternameNumber;
	}

	public void setAlternameNumber(String alternameNumber) {
		this.alternameNumber = alternameNumber;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getOnboardDate() {
		return onboardDate;
	}

	public void setOnboardDate(Date onboardDate) {
		this.onboardDate = onboardDate;
	}

	public Date getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(Date liveDate) {
		this.liveDate = liveDate;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCoutryCode() {
		return coutryCode;
	}

	public void setCoutryCode(String coutryCode) {
		this.coutryCode = coutryCode;
	}

	@Override
	public String toString() {
		return "ClientConfig [id=" + id + ", clientName=" + clientName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", alternameNumber=" + alternameNumber + ", clientCode=" + clientCode
				+ ", registrationNumber=" + registrationNumber + ", onboardDate=" + onboardDate + ", liveDate="
				+ liveDate + ", clientType=" + clientType + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", pincode=" + pincode + ", stateCode=" + stateCode + ", coutryCode=" + coutryCode
				+ "]";
	}

}
