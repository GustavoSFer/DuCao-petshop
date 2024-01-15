package com.fernandes.ecommercelovepet.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fernandes.ecommercelovepet.service.exception.ResourceNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<StanderError> ResourceNotFoundError(ResourceNotFound e, HttpServletRequest request) {
		String error = "Recurso não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StanderError err = new StanderError(Instant.now(), status.value(), error, "Pessoa não encontrada em nosso banco de dados", request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

}
