package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COUNTRY")
public class Country extends AuditEntity {

	@Id
	@Column(name = "COUNTRY_CD", unique = true)
	@NotNull(message = "Country Code is required")
	private String countryCode;

	@NotNull(message = "Country Name is required")
	@Column(name = "COUNTRY_NAME", nullable = false)
	private String countryName;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(mappedBy = "country")
	private Set<State> states = new HashSet<State>();

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<State> getStates() {

		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}
