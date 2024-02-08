package com.fernandes.ecommercelovepet.service.exception;

public class LoginError extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoginError(String msg) {
		super(msg);
	}

}
