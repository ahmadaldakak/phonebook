package com.example.demo.requestBody;

public class filled {
	String content;
	int type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public filled(String content, int type) {
		super();
		this.content = content;
		this.type = type;
	}
	@Override
	public String toString() {
		return "filled [content=" + content + ", type=" + type + "]";
	}
	
}
