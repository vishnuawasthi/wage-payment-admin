package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STATE")
public class State extends AuditEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "SEQ_CLIENT_CONFIG")
	@Column(name = "STATE_CODE", unique = true)
	private String stateCode;

	@NotNull(message = "State Name is required")
	@Column(name = "STATE_NAME", nullable = false)
	private String stateName;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "COUNTRY_CODE")
	private Country country;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
