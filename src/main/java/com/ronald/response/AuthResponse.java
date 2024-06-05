package com.ronald.response;

public class AuthResponse {
	
	private String jwt;
	private String message;
	public AuthResponse(String jwt, String message) {
		super();
		this.jwt = jwt;
		this.message = message;
	}
	 
	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
