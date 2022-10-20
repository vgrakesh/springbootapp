package com.example.demo.ui.requestModels;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest {
	@Size(min = 2, message = "First name cannot be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	@Digits(integer = 10, fraction = 0)
	@Size(min = 10, max = 10, message = "Phone should be exactly 10 digits")
	private String phone;
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 20, message = "Password must be between 8 to 20 characters")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
