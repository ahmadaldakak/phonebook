package com.example.demo.requestBody;

import java.util.List;

import com.example.demo.models.field_types;

//public class FieldTypesResponseModel {
//	List<Data> data;
//
//	public List<Data> getData() {
//		return data;
//	}
//
//	public void setData(List<Data> data) {
//		this.data = data;
//	}
//
//	public FieldTypesResponseModel(List<Data> data) {
//		super();
//		this.data = data;
//	}
//
//	public FieldTypesResponseModel() {
//		super();
//	}
//	
//}

public class FieldTypesResponseModel
{
	field_types field;
	List<field_types> list;
	public field_types getField() {
		return field;
	}
	public void setField(field_types field) {
		this.field = field;
	}
	public List<field_types> getList() {
		return list;
	}
	public void setList(List<field_types> list) {
		this.list = list;
	}
	public FieldTypesResponseModel(field_types field, List<field_types> list) {
		super();
		this.field = field;
		this.list = list;
	}
	public FieldTypesResponseModel() {
		super();
	}
	
}
