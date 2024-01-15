package com.fernandes.ecommercelovepet.resource.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StanderError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestemp;
	private Integer Status;
	private String error;
	private String message;
	private String path;
	
	public StanderError() {}

	public StanderError(Instant timestemp, Integer status, String error, String message, String path) {
		super();
		this.timestemp = timestemp;
		Status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Instant timestemp) {
		this.timestemp = timestemp;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	};
	
}
