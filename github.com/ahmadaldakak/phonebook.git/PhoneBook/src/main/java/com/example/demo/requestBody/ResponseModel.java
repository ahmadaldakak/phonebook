package com.example.demo.requestBody;

public class ResponseModel {
	String massage;
	Object data;
	public ResponseModel(String massage, Object data) {
		super();
		this.massage = massage;
		this.data = data;
	}
	public ResponseModel() {
		super();
		this.massage="";
		// TODO Auto-generated constructor stub
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
