package com.fernandes.ecommercelovepet.util;

public class ResponseMessages {
	
	private boolean status;
	private String msg;
	private Integer id;
	
	public ResponseMessages(boolean status, String msg, Integer id) {
		super();
		this.status = status;
		this.msg = msg;
		this.id = id;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
