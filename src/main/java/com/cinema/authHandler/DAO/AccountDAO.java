package com.cinema.authHandler.DAO;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.authHandler.model.Account;

@Repository
@Transactional
public class AccountDAO{
	
	@Autowired
	private EntityManager manager;
	
	public void save(Account account) {
		manager.persist(account);
	}
	
	public Account findById(long id) {
		return manager.find(Account.class, id);
	}
	
	
	public void update(Account account) {
		
	}
	
}
