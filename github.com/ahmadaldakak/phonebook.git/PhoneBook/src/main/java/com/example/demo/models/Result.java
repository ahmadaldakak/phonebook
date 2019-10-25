package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Result {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	String result_text;
	
	///////////////////////////
	
	@OneToMany(mappedBy = "logResult" , cascade = CascadeType.ALL)
	@JsonIgnore
	List<Log> logs = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult_text() {
		return result_text;
	}

	public void setResult_text(String result_text) {
		this.result_text = result_text;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", result_text=" + result_text + ", logs=" + logs + "]";
	}
	
}
