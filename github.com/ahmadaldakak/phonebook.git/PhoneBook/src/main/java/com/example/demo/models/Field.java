package com.example.demo.models;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Field {	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int Id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "contact_id")
	Contact fieldContact;
	
	@ManyToOne
	@JoinColumn(name = "filled_type_id")
	field_types field_type;
	
	String content;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Contact getFieldContact() {
		return fieldContact;
	}
	public void setFieldContact(Contact fieldContact) {
		this.fieldContact = fieldContact;
	}
	public field_types getField_type() {
		return field_type;
	}
	public void setField_type(field_types field_type) {
		this.field_type = field_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Field [Id=" + Id + ", fieldContact=" + fieldContact + ", field_type=" + field_type + ", content="
				+ content + "]";
	}
	
}
