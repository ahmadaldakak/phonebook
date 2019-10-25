package com.example.demo.requestBody;

import com.example.demo.models.User;

public class SignInResponse {

	String sessionKey;
	User user;
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SignInResponse(String sessionKey, User user) {
		super();
		this.sessionKey = sessionKey;
		this.user = user;
	}
	
}
