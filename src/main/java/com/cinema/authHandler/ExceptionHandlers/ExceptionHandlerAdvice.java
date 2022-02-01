package com.cinema.authHandler.ExceptionHandlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cinema.authHandler.exception.AccountNotFound;
import com.cinema.authHandler.response.Data;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(AccountNotFound.class)
	 public ResponseEntity<Data> handleUnAuthorisedRequestException(){
	  return ResponseEntity.status(400).body(new Data(401,"BAD_REQUEST",null));
	 }
}
	