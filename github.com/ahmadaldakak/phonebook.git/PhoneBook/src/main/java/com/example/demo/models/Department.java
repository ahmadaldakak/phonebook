package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	String name;
	
	/////////////////////////////////
	@OneToMany(mappedBy = "userDepartment" , cascade = CascadeType.ALL)
	@JsonIgnore
	List<User> users = new ArrayList();
	

	@OneToMany(mappedBy = "contactDepartment" , cascade = CascadeType.ALL)
	@JsonIgnore
	List<Contact> contacts = new ArrayList();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


//	@Override
//	public String toString() {
//		return "Department [id=" + id + ", name=" + name+ "]";
//	}
//	
	
}
