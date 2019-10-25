package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int user_id;
	String name;
	String birthday;
	String password;
	String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "user_type_id")
	UserType userType;
	
	@ManyToOne
	@JoinColumn(name = "dep_id")
	Department userDepartment;
		
	@OneToMany(mappedBy = "sessionUser" ,  cascade = CascadeType.ALL)
	@JsonIgnore
	List<Sessions> sessions = new ArrayList();
	
	@OneToMany(mappedBy = "contactUser",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Contact> contacts = new ArrayList();
	
	@OneToMany(mappedBy = "Loguser",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Log> Logs = new ArrayList();

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Department getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(Department userDepartment) {
		this.userDepartment = userDepartment;
	}
	@JsonIgnore
	public List<Sessions> getSessions() {
		return sessions;
	}

	public void setSessions(List<Sessions> sessions) {
		this.sessions = sessions;
	}
	@JsonIgnore
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	@JsonIgnore
	public List<Log> getLogs() {
		return Logs;
	}

	public void setLogs(List<Log> logs) {
		Logs = logs;
	}

//	@Override
//	public String toString() {
//		Map<String,Object> map = new HashMap();
//		map.put("name", name);
//		map.put("password", password);
//		System.out.println(map.toString());
//		return "{ user_id=" + user_id + ", name=" + name + ", birthday=" + birthday + ", password=" + password
//				+ ", userType=" + userType + ", userDepartment=" + userDepartment + ", sessions=" + sessions
//				+ ", contacts=" + contacts + ", Logs=" + Logs + "}";
//	}
}