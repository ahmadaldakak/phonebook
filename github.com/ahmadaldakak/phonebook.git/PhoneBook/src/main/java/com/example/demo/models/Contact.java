package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	String name;
	String address;
	Date birthday;
	String image;
	Date creationDate;
	@OneToMany(mappedBy = "fieldContact" , cascade = CascadeType.ALL)
	List<Field> fields = new ArrayList();	
	@ManyToOne
	@JoinColumn(name = "state")
	State state;
	@ManyToOne
	@JoinColumn(name = "user_id")
	User contactUser;
	
	@ManyToOne
	@JoinColumn(name = "dep_id")
	Department contactDepartment;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String email) {
		this.address = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public User getContactUser() {
		return contactUser;
	}

	public void setContactUser(User contactUser) {
		this.contactUser = contactUser;
	}

	public Department getContactDepartment() {
		return contactDepartment;
	}

	public void setContactDepartment(Department contactDepartment) {
		this.contactDepartment = contactDepartment;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + address + ", birthday=" + birthday + ", image="
				+ image + ", creationDate=" + creationDate + ", fields=" + fields + ", state=" + state
				+ ", contactUser=" + contactUser + ", contactDepartment=" + contactDepartment + "]";
	}

	public Contact(int id, String name, String email, Date birthday, String image, Date creationDate,
			List<Field> fields, State state, User contactUser, Department contactDepartment) {
		super();
		this.id = id;
		this.name = name;
		this.address = email;
		this.birthday = birthday;
		this.image = image;
		this.creationDate = creationDate;
		this.fields = fields;
		this.state = state;
		this.contactUser = contactUser;
		this.contactDepartment = contactDepartment;
	}

	public Contact() {
		super();
	}
	
}
