package com.cinema.authHandler.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cinema.authHandler.response.Data;
import com.cinema.authHandler.response.GenericError;
import com.cinema.authHandler.service.JWTService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtVerificationFilter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private JWTService jwtService;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// check for valid JWT token
		// Skipping validation for URL's auth URLS
		if (validateRequestHeaders(request, response)) {
			chain.doFilter(request, response);
		}else {
			response.setStatus(403);
			response.setContentType("application/json");
			response.getWriter().write(WriteErrorResponse());
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean validateRequestHeaders(HttpServletRequest request, HttpServletResponse response) {
		// Skip bearer validation for Auth URL's
		if (request.getRequestURI().contains("/auth/login") || request.getRequestURI().contains("/auth/refresh")) {
			return true;
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String apiKey = httpRequest.getHeader("X-API-KEY");
		String authorization = httpRequest.getHeader("Authorization");
		if (apiKey != null || authorization != null) {
			String token = authorization.replace("BEARER ", "");
			if (jwtService.verify(token)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public String WriteErrorResponse() throws JsonProcessingException {
		Data responseData = new Data(403, HttpStatus.UNAUTHORIZED.name(), new GenericError("Jwt verification failed"));
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(responseData);
	}
}
