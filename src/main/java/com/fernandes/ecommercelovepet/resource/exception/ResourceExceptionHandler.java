package com.fernandes.ecommercelovepet.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandes.ecommercelovepet.service.exception.CreateError;
import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<StanderError> ResourceNotFoundError(ResourceNotFound e, HttpServletRequest request) {
		String error = "Recurso não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderError err = new StanderError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CreateError.class)
	public ResponseEntity<StanderError> CreateException(CreateError e, HttpServletRequest request) {
		String error = e.getMessage();
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderError err = new StanderError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

}
