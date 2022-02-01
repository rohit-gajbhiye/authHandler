package com.cinema.authHandler.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cinema.authHandler.util.DateUtil;

@Entity
@Table(name="AUTHENTICATION_TOKEN")
public class AuthenticationToken {
	
	
	public enum Type{
		LOGIN,
		REFRESH
	}
	
	public enum Status {
		ACTIVE,
		INACTIVE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHENTICATION_ID")
	private Authentication authentication;
	@Column(name="TOKEN")
	private String refreshToken;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE")
	private Type type;
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	@Column(name="WHEN_CREATED")
	private Timestamp whenCreated;
	@Column(name="TLM")
	private Timestamp TLM;
	
	
	public AuthenticationToken() {}
	
	/**
	 * 
	 * @param authentication
	 * @param refreshToken
	 * @param type
	 * @param status
	 * @param whenCreated
	 * @param tLM
	 */
	public AuthenticationToken(Authentication authentication, String refreshToken, Type type) {
		super();
		this.authentication = authentication;
		this.refreshToken = refreshToken;
		this.type = type;
		this.status = Status.ACTIVE;
		this.whenCreated = DateUtil.dbDateNow();
		TLM = DateUtil.dbDateNow();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
}
