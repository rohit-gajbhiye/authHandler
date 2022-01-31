 package com.cinema.authHandler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	public enum AccountStatus {
		ACTIVE,
		CLOSED,
		NEW
	}

	@Id
	//Identity expects AUTO_INCREMENT
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="SECONDARY_EMAIL")
	private String secondaryEmail;
	@Column(name="PHONE")
	private String phone;
	@Column(name="SECONDARY_PHONE")
	private String secondaryPhone;
	@Column(name="PHOTO_VERIFIED")
	private Boolean photoVerified;
	@Enumerated(EnumType.STRING)
	@Column(name="ACCOUNT_STATUS")
	private AccountStatus accountStatus;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AUTH_ID")
	private Authentication authentication;

	public Account() {
		
	}
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param secondaryEmail
	 * @param phone
	 * @param secondaryPhone
	 * @param photoVerified
	 */
	public Account(String firstName, String lastName, String email, String secondaryEmail, String phone,
			String secondaryPhone, Boolean photoVerified,AccountStatus accountStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.secondaryEmail = secondaryEmail;
		this.phone = phone;
		this.secondaryPhone = secondaryPhone;
		this.photoVerified = photoVerified;
		this.accountStatus = accountStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public Boolean getPhotoVerified() {
		return photoVerified;
	}

	public void setPhotoVerified(Boolean photoVerified) {
		this.photoVerified = photoVerified;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	
	
}
