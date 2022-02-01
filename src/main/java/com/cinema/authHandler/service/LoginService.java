package com.cinema.authHandler.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.cinema.authHandler.DAO.AuthenticationDAO;
import com.cinema.authHandler.DAO.AuthenticationTokenDAO;
import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.model.Authentication;
import com.cinema.authHandler.model.AuthenticationToken;
import com.cinema.authHandler.model.AuthenticationToken.Type;
import com.cinema.authHandler.value.Tokens;

@Service
public class LoginService {
	
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationDAO authDAO;
	
	@Autowired
	AuthenticationTokenDAO authTokenDAO;
	
	
	
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws AccountNotFound
	 */
	public Tokens doLogin(String username,String password) throws AccountNotFound {
		Authentication auth = authDAO.findByUsername(username);
		if (!auth.getPassword().equals(password)) {
			throw new AccountNotFound();
		}
		String accessToken = jwtService.generateJWT(auth,UUID.randomUUID().toString());
		String refreshToken = createRefreshToken(auth,Type.LOGIN);
		return new Tokens(accessToken,refreshToken);
	}
	
	public Tokens refreshToken(String jwt) throws AccountNotFound {
		DecodedJWT dJWT = jwtService.decodeToken(jwt);
		if(dJWT == null) {
			throw new AccountNotFound();
		}
		Authentication auth = authDAO.findByUsername(dJWT.getSubject());
		String refreshToken = createRefreshToken(auth,Type.REFRESH);
		String accessToken = jwtService.generateJWT(auth,UUID.randomUUID().toString());
		return new Tokens(accessToken,refreshToken);
	}
	
	/**
	 * 
	 * @param auth
	 * @param type
	 * @return
	 * @throws AccountNotFound
	 */
	public String createRefreshToken(Authentication auth,Type type) throws AccountNotFound {
		AuthenticationToken authToken =
				authTokenDAO.retriveActiveRecordByAuthenticationId(auth.getId());
		if(authToken!=null) {
			authTokenDAO.inActiveLastRecord(authToken.getId());
		}
		String refreshTokenId = UUID.randomUUID().toString();
		AuthenticationToken newAuthToken = new AuthenticationToken(auth,refreshTokenId,type);
		authTokenDAO.save(newAuthToken);
		return jwtService.generateRefreshToken(auth, refreshTokenId);
	}

}
