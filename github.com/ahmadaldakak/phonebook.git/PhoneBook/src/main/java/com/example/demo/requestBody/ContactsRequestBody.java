package com.example.demo.requestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactsRequestBody {

	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String email) {
		this.address = email;
	}
	public ContactsRequestBody(Date birthday, String email, String image, String name , List<filled> filled) {
		super();
		this.birthday = birthday;
		this.address = email;
		this.image = image;
		this.name = name;
		Filled = filled;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<filled> getFilled() {
		return Filled;
	}
	public void setFilled(List<filled> filled) {
		Filled = filled;
	}
	Date birthday;
	String address;
	String image;
	String name;
	List<filled> Filled = new ArrayList<filled>();
}
