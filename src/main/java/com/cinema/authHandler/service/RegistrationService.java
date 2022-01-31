package com.cinema.authHandler.service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.authHandler.DAO.AccountDAO;
import com.cinema.authHandler.DAO.AuthenticationDAO;
import com.cinema.authHandler.model.Account;
import com.cinema.authHandler.model.Authentication;
import com.cinema.authHandler.model.Account.AccountStatus;
import com.cinema.authHandler.model.Authentication.Status;

@Service
public class RegistrationService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private AuthenticationDAO authenticationDAO;
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 */
	public void register(String firstName,String lastName,String phone,String email) {
		Account account = new Account(firstName,lastName,email,null,phone,null,false,AccountStatus.NEW);
		accountDAO.save(account);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws AccountNotFoundException
	 */
	public Account findById(long id) throws AccountNotFoundException{
		Account account = accountDAO.findById(id);
		if(account==null)
			throw new AccountNotFoundException();
		return account;
	}
	
	/**
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @throws AccountNotFoundException
	 */
	@Transactional
	public void registerUser(long id, String username,String password) throws AccountNotFoundException {
		Account account = findById(id);
		Authentication auth = new Authentication(username,password,Status.ACTIVE);
		authenticationDAO.save(auth);
		account.setAuthentication(auth);
	}

}
