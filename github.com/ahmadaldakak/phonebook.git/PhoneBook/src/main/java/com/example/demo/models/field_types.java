package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class field_types {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	int id;
	String type_name;
	
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	field_types parent;
	////////////////////////////
	
	@OneToMany(mappedBy = "field_type" ,cascade = CascadeType.ALL)
	@JsonIgnore
	List<Field> Fields = new ArrayList();
	
	@OneToMany(mappedBy = "parent")
	@JsonIgnore
	List<field_types> fieldtypes = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	public field_types getParent() {
		return parent;
	}

	public void setParent(field_types parent) {
		this.parent = parent;
	}
	@JsonIgnore
	public List<Field> getFields() {
		return Fields;
	}

	public void setFields(List<Field> fields) {
		Fields = fields;
	}
	
	public List<field_types> getFieldtypes() {
		return fieldtypes;
	}

	public void setFieldtypes(List<field_types> fieldtypes) {
		this.fieldtypes = fieldtypes;
	}

	@Override
	public String toString() {
		return "field_types [id=" + id + ", type_name=" + type_name + ", parent=" + parent + ", Fields=" + Fields
				+ ", fieldtypes=" + fieldtypes + "]";
	}
	
}
