package com.example.demo.models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Sessions {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	User sessionUser;
	
	String sessionKey;
	int is_active;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
	public Sessions(User sessionUser, String sessionKey, int is_active) {
		super();
		this.sessionUser = sessionUser;
		this.sessionKey = sessionKey;
		this.is_active = is_active;
	}
	
	public Sessions(int id, User sessionUser, String sessionKey, int is_active) {
		super();
		this.id = id;
		this.sessionUser = sessionUser;
		this.sessionKey = sessionKey;
		this.is_active = is_active;
	}
	
	public Sessions() {
		super();
	}
	@Override
	public String toString() {
		return "Sessions [id=" + id + ", sessionUser=" + sessionUser + ", sessionKey=" + sessionKey + ", is_active="
				+ is_active + "]";
	}
	
}
