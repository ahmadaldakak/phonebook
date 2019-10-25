package com.example.demo.models;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Log {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User Loguser;
	
	@ManyToOne
	@JoinColumn(name = "function_id")
	Function Logfunction;
	
	@ManyToOne
	@JoinColumn(name = "result_id")
	Result logResult;
	Date datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getLoguser() {
		return Loguser;
	}
	public void setLoguser(User loguser) {
		Loguser = loguser;
	}
	public Function getLogfunction() {
		return Logfunction;
	}
	public void setLogfunction(Function logfunction) {
		Logfunction = logfunction;
	}
	public Result getLogResult() {
		return logResult;
	}
	public void setLogResult(Result logResult) {
		this.logResult = logResult;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", Loguser=" + Loguser.getName() + ", Logfunction=" + Logfunction.getFunction_name() + ", logResult=" + logResult.getResult_text()
				+ ", datetime=" + datetime + "]";
	}
	
	
	
}
