package com.cinema.authHandler.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.authHandler.response.Data;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(method =RequestMethod.GET, value = "/account", produces="application/json")
	public ResponseEntity<Data> register(HttpServletRequest request , HttpServletResponse response){
		return ResponseEntity.ok(new Data(200,HttpStatus.OK.name(),null));
	}

}
