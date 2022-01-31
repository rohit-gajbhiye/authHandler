package com.cinema.authHandler.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.model.Authentication;

@Repository
@Transactional
public class AuthenticationDAO {

	public static final String FIND_BY_USERNAME_QUERY = "from Authentication a where a.username = :username";

	@Autowired
	private EntityManager manager;

	/**
	 * 
	 * @param auth
	 */
	public void save(Authentication auth) {
		manager.persist(auth);
	}

	/**
	 * 
	 * @param username
	 * @return
	 * @throws AccountNotFound
	 */
	public Authentication findByUsername(String username) throws AccountNotFound {
		TypedQuery<Authentication> query = manager.createQuery(FIND_BY_USERNAME_QUERY, Authentication.class);
		query.setParameter("username", username);
		Authentication record = query.getSingleResult();
		if (record == null)
			throw new AccountNotFound();
		return record;
	}

}
