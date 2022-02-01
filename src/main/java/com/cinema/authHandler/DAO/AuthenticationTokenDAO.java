package com.cinema.authHandler.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.model.AuthenticationToken;

@Repository
@Transactional
public class AuthenticationTokenDAO {
	
	public static final String FIND_BY_USERNAME_QUERY = "from AuthenticationToken a where a.authentication.id = :authId"
			+ " and a.status='ACTIVE'";
	
	public static final String INACTIVE_AUTH_RECORD ="UPDATE AUTHENTICATION_TOKEN SET STATUS='INACTIVE' WHERE ID =:id";

	@Autowired
	private EntityManager manager;

	/**
	 * 
	 * @param auth
	 */
	public void save(AuthenticationToken auth) {
		manager.persist(auth);
	}
	
	/**
	 * 
	 * @param authenticationId
	 * @return
	 * @throws AccountNotFound
	 */
	public AuthenticationToken retriveActiveRecordByAuthenticationId(long authenticationId) throws AccountNotFound {
		TypedQuery<AuthenticationToken> query = 
				manager.createQuery(FIND_BY_USERNAME_QUERY, AuthenticationToken.class);
		query.setParameter("authId", authenticationId);
		//Assuming there will be single active record at a time
		AuthenticationToken token = null;
		try {
			token = query.getSingleResult();
		}catch(NoResultException noRsltEx) {
			
		}catch(NonUniqueResultException nonUniqueEx) {
			
		}
		return token;
	}
	
	/**
	 * 
	 * @param authenticationTokenId
	 */
	public void inActiveLastRecord(long authenticationTokenId) {
		Query query = manager.createNativeQuery(INACTIVE_AUTH_RECORD);
		query.setParameter("id", authenticationTokenId);
		query.executeUpdate();
	}
	
}
