package com.app.entities;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class TestForm {

	@NotEmpty(message = "Name is required")
	@Size(min=4,message="Name should not be less than 4 characters")  
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestForm [name=" + name + "]";
	}
	
	

}
