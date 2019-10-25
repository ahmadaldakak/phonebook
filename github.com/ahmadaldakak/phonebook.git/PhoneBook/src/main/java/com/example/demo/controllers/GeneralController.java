package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Functions;
import com.example.demo.requestBody.ResponseModel;

@RestController
public class GeneralController {

	
	@Autowired
	Functions functions;
	
	@GetMapping("/fieldtypes")
	ResponseEntity<ResponseModel> getFieldTypes()
	{
		return functions.getFieldTypeById();
	}
}
