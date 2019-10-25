package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Function {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	String function_name;
	
	//////////////////////////////////////
	@OneToMany(mappedBy = "Logfunction" , cascade = CascadeType.ALL)
	@JsonIgnore
	List<Log> Logs = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	public List<Log> getLogs() {
		return Logs;
	}

	public void setLogs(List<Log> logs) {
		Logs = logs;
	}

	@Override
	public String toString() {
		return "Function [id=" + id + ", function_name=" + function_name + ", Logs=" + Logs + "]";
	}
	
}
