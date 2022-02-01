package com.cinema.authHandler.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.authHandler.request.RegisterUser;
import com.cinema.authHandler.request.Registration;
import com.cinema.authHandler.response.Data;
import com.cinema.authHandler.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class UserController {
	
	@Autowired
	private RegistrationService registrationService; 
	
	@RequestMapping(method =RequestMethod.POST, value = "/personalInfo", consumes="application/json")
	public ResponseEntity<Data> register(HttpServletRequest request , HttpServletResponse response,
			@RequestBody Registration registration){
		registrationService.register(registration.getFirstName(), registration.getLastName(),
				registration.getPhone(), registration.getEmail());
		return ResponseEntity.ok(new Data(200,HttpStatus.OK.name(),null));
	}
	
	@RequestMapping(method =RequestMethod.POST, value = "/user", consumes="application/json")
	public ResponseEntity<Data> registerUsername(HttpServletRequest request , HttpServletResponse response,
			@RequestBody RegisterUser registerUser) throws AccountNotFoundException{
		registrationService.registerUser(registerUser.getId(), registerUser.getUsername(), registerUser.getPassword());
		return ResponseEntity.ok(new Data(200,HttpStatus.OK.name(),null));
	}

}
