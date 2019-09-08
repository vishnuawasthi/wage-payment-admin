package com.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.validators.EmailId;
import com.app.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientConfigDTO {
	
	//@NotEmpty(message = "id is required")
	@NotNull(message="id is required")
	private Long id;

	@NotEmpty(message = "Client name is required")
	@Pattern(regexp = "^(?:[^0-9]+[A-Za-z0-9\\_ ]*|)$", message = "Client name only accepts alphanumeric,underscope(_) and should not start with digits")
	private String clientName;

	@NotEmpty(message = "Email is required")
	@EmailId(regExp="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
	private String email;

	@Pattern(regexp = "^(?:[0-9]{10}|)$", message = "Contact number accepts only digit  of length 10")
	@NotEmpty(message = "Contact number is required")
	private String contactNumber;

	@Pattern(regexp = "^(?:[0-9]{10}|)$", message = "Alternate number accepts only digit  of length 10")
	private String alternateNumber;

	//@Pattern(regexp = "^(?:[A-Za-z0-9\\_]*|)$", message = "Client code only accept alphanumeric and underscore)")
	//@NotEmpty(message = "Client Code is required")
	//@UniqueValue(property="clientCode")
	//private String clientCode;

	@NotEmpty(message = "Registration number is required")
	@Pattern(regexp = "^(?:[0-9]{12}|)$", message = "Registration number accepts only digits of length 12")
	private String registrationNumber;

	//@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	//private Date onboardDate;

	//2019-09-08
	//@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//private Date liveDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String liveDateTxt;

	@NotEmpty(message = "Onboard date is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String onboardDateTxt;

	@NotEmpty(message = "Client type is required")
	private String clientType;

	@NotEmpty(message = "Address line1 is required")
	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine1 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	private String addressLine1;

	@Pattern(regexp = "^(?:[A-Za-z0-9 \\_\\,\\-]*|)$", message = "AddressLine2 only accept alphanumeric and hyphen (-), comma (,), underscore (_))")
	private String addressLine2;

	@NotEmpty(message = "Pincode is required")
	@Pattern(regexp = "^(?:[0-9]{6}|)$", message = "Pincode accepts only digits of length 6")
	private String pincode;

	@NotEmpty(message = "State code is required")
	private String stateCode;

	@NotEmpty(message = "Coutry code is required")
	private String coutryCode;

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

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
