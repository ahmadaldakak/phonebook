package com.example.demo.models;

public class UserRequestbody {

	public String name;
	public String birthday;
	public String password;
	public int dep_id;
	public int user_type_id;
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
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public int getUser_type_id() {
		return user_type_id;
	}
	public void setUser_type_id(int user_type_id) {
		this.user_type_id = user_type_id;
	}
	public UserRequestbody(String name, String birthday, String password, int dep_id, int user_type_id) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.password = password;
		this.dep_id = dep_id;
		this.user_type_id = user_type_id;
	}
	public UserRequestbody() {
	}

}

