package com.cinema.authHandler.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cinema.authHandler.util.DateUtil;

@Entity
@Table(name="AUTHENTICATION")
public class Authentication {
	
	public enum Status {
		ACTIVE,
		IN_ACTIVE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="USER_NAME")
	private String username;
	@Column(name="PASSWORD_HASH")
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	@Column(name="LAST_LOGIN_TLM")
	private Date lastLoginTLM;
	@Column(name="RETRY_TLM")
	private Date retryTLM;
	@Column(name="PASSWORD_CHANGE_TLM")
	private Date passwordChangeTLM;
	@Column(name="LAST_LOCKED_TLM")
	private Date lastLockedTLM;
	@Column(name="LAST_RESET_TLM")
	private Date lastResetTLM;
	@Column(name="WHEN_CREATED")
	private Date whenCreated;
	@Column(name="TLM")
	private Date TLM;
	
	//Need for hibernate
	public Authentication() {
		
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @param status
	 */
	public Authentication(String username, String password, Status status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		// TODO create util class to return current date and time
		this.whenCreated = DateUtil.now();
		this.TLM = DateUtil.now();
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Status getStatus() {
		return status;
	}

	public Date getLastLoginTLM() {
		return lastLoginTLM;
	}

	public Date getRetryTLM() {
		return retryTLM;
	}

	public Date getPasswordChangeTLM() {
		return passwordChangeTLM;
	}

	public Date getLastLockedTLM() {
		return lastLockedTLM;
	}

	public Date getLastResetTLM() {
		return lastResetTLM;
	}

	public Date getWhenCreated() {
		return whenCreated;
	}

	public Date getTLM() {
		return TLM;
	}
}
