package com.example.demo.ui.requestModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserRequest {
	@Size(min = 2, message = "First name cannot be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
