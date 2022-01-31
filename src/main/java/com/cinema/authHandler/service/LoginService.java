package com.cinema.authHandler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.authHandler.DAO.AuthenticationDAO;
import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.model.Authentication;

@Service
public class LoginService {
	
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationDAO authDAO;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws AccountNotFound
	 */
	public String doLogin(String username,String password) throws AccountNotFound {
		Authentication auth = authDAO.findByUsername(username);
		if (!auth.getPassword().equals(password)) {
			throw new AccountNotFound();
		}
		return jwtService.generateJWT(auth);
	}

}
