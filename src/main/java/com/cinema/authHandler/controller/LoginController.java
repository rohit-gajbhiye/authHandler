package com.cinema.authHandler.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.request.Login;
import com.cinema.authHandler.request.RefreshToken;
import com.cinema.authHandler.response.Data;
import com.cinema.authHandler.response.Token;
import com.cinema.authHandler.service.LoginService;
import com.cinema.authHandler.value.Tokens;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<Data> login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Login login) throws AccountNotFound {
		Tokens tokens = loginService.doLogin(login.getUsername(), login.getPassword());
		Data responseData = new Data(200, HttpStatus.OK.name(),
				new Token(tokens.getAccessToken(),tokens.getRefreshToken()));
		return ResponseEntity.ok(responseData);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/refresh")
	public ResponseEntity<Data> refreshToken(HttpServletRequest request, HttpServletResponse response,
			@RequestBody RefreshToken token) throws AccountNotFound {
		Tokens tokens = loginService.refreshToken(token.getRefreshToken());
		Data responseData = new Data(200, HttpStatus.OK.name(),
				new Token(tokens.getAccessToken(),tokens.getRefreshToken()));
		return ResponseEntity.ok(responseData);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/logout")
	public ResponseEntity<Data> logout(HttpServletRequest request, HttpServletResponse response) 
			throws AccountNotFound {
		return null;
	}

}
