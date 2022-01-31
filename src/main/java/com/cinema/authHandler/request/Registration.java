package com.cinema.authHandler.request;

public class Registration {
	
	private String firstName;
	private String lastName;
	private String email;
	private String secondaryEmail;
	private String phone;
	private String secondaryPhone;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public String getPhone() {
		return phone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	
	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", secondaryEmail=" + secondaryEmail + ", phone=" + phone + ", secondaryPhone=" + secondaryPhone
				+ "]";
	}
	
}
