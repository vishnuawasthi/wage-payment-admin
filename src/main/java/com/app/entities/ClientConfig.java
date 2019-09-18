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
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.validators.EmailId;
import com.app.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CLIENT_CONFIG")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "SEQ_CLIENT_CONFIG", sequenceName = "SEQ_CLIENT_CONFIG")
public class ClientConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_CONFIG")
	@Column(name = "ID")
	private Long id;

	/**
	 * You may use the following regex:
	 * 
	 * ^[A-Za-z]\w*$
	 * 
	 * ^ - start of string 
	 * [A-Za-z] - any ASCII letter
	 *  \w* - zero or more letters/digits/_ $ - end of string.
	 * 
	 */
	@NotEmpty(message = "Client name is required")
	@Pattern(regexp = "^[A-Za-z\\ \\_ \\-][\\w \\ \\-]*$", message = "Client name only accepts alphanumeric,underscope(_),hyphen(-) and should not start with digits")
	@Column(name = "CLIENT_NAME", nullable = false)
	private String clientName;

	@NotEmpty(message = "Email is required")
	@EmailId(regExp="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Pattern(regexp = "^(?:[0-9]{10}|)$", message = "Contact number accepts only digit  of length 10")
	@NotEmpty(message = "Contact number is required")
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "ALT_CONTACT_NBR")
	@Pattern(regexp = "^(?:[0-9]{10}|)$", message = "Alternate number accepts only digit  of length 10")
	private String alternateNumber;

	@Pattern(regexp = "^(?:[A-Za-z0-9\\_]*|)$", message = "Client code only accept alphanumeric and underscore)")
	@NotEmpty(message = "Client Code is required")
	@Column(name = "CLIENT_CODE", nullable = false, unique = true)
	@UniqueValue(property="clientCode")
	private String clientCode;

	@NotEmpty(message = "Registration number is required")
	@Pattern(regexp = "^(?:[0-9]{12}|)$", message = "Registration number accepts only digits of length 12")
	@Column(name = "REG_NBR")
	private String registrationNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "ONBOARD_DT")
	private Date onboardDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "LIVE_DT")
	private Date liveDate;

	@Transient
	private String liveDateTxt;

	@NotEmpty(message = "Onboard date is required")
	@Transient
	private String onboardDateTxt;

	@NotEmpty(message = "Client type is required")
	@Column(name = "CLIENT_TYPE")
	private String clientType;

	@NotEmpty(message = "Address line1 is required")
	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine1 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine2 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	private String addressLine2;

	@NotEmpty(message = "Pincode is required")
	@Column(name = "PINCODE")
	// @Max(value = 6, message = "Pincode can not be more than 6 digits long")
	@Pattern(regexp = "^(?:[0-9]{6}|)$", message = "Pincode accepts only digits of length 6")
	private String pincode;

	@NotEmpty(message = "State code is required")
	@Column(name = "ST_CD")
	private String stateCode;

	@NotEmpty(message = "Coutry code is required")
	@Column(name = "COUNTRY_CD")
	private String coutryCode;

	
	@OneToMany(mappedBy = "clientConfig")
	private Set<Employee> employees = new HashSet<Employee>();

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

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
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

	public String getLiveDateTxt() {
		return liveDateTxt;
	}

	public void setLiveDateTxt(String liveDateTxt) {
		this.liveDateTxt = liveDateTxt;
	}

	public String getOnboardDateTxt() {
		return onboardDateTxt;
	}

	public void setOnboardDateTxt(String onboardDateTxt) {
		this.onboardDateTxt = onboardDateTxt;
	}

	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "ClientConfig [id=" + id + ", clientName=" + clientName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", alternameNumber=" + alternateNumber + ", clientCode=" + clientCode
				+ ", registrationNumber=" + registrationNumber + ", onboardDate=" + onboardDate + ", liveDate="
				+ liveDate + ", clientType=" + clientType + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", pincode=" + pincode + ", stateCode=" + stateCode + ", coutryCode=" + coutryCode
				+ "]";
	}

}
