package com.cinema.authHandler.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Timestamp retryTLM;
	@Column(name="PASSWORD_CHANGE_TLM")
	private Timestamp passwordChangeTLM;
	@Column(name="LAST_LOCKED_TLM")
	private Timestamp lastLockedTLM;
	@Column(name="LAST_RESET_TLM")
	private Timestamp lastResetTLM;
	@Column(name="WHEN_CREATED")
	private Timestamp whenCreated;
	@Column(name="TLM")
	private Timestamp TLM;
	@OneToMany(fetch = FetchType.LAZY)
	private List<AuthenticationToken> tokens;
	
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
		this.whenCreated =DateUtil.dbDateNow();
		this.TLM = DateUtil.dbDateNow();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getLastLoginTLM() {
		return lastLoginTLM;
	}
	public void setLastLoginTLM(Date lastLoginTLM) {
		this.lastLoginTLM = lastLoginTLM;
	}
	public Timestamp getRetryTLM() {
		return retryTLM;
	}
	public void setRetryTLM(Timestamp retryTLM) {
		this.retryTLM = retryTLM;
	}
	public Timestamp getPasswordChangeTLM() {
		return passwordChangeTLM;
	}
	public void setPasswordChangeTLM(Timestamp passwordChangeTLM) {
		this.passwordChangeTLM = passwordChangeTLM;
	}
	public Timestamp getLastLockedTLM() {
		return lastLockedTLM;
	}
	public void setLastLockedTLM(Timestamp lastLockedTLM) {
		this.lastLockedTLM = lastLockedTLM;
	}
	public Timestamp getLastResetTLM() {
		return lastResetTLM;
	}
	public void setLastResetTLM(Timestamp lastResetTLM) {
		this.lastResetTLM = lastResetTLM;
	}
	public Timestamp getWhenCreated() {
		return whenCreated;
	}
	public void setWhenCreated(Timestamp whenCreated) {
		this.whenCreated = whenCreated;
	}
	public Timestamp getTLM() {
		return TLM;
	}
	public void setTLM(Timestamp tLM) {
		TLM = tLM;
	}
	public List<AuthenticationToken> getTokens() {
		return tokens;
	}
	public void setTokens(List<AuthenticationToken> tokens) {
		this.tokens = tokens;
	}
}
