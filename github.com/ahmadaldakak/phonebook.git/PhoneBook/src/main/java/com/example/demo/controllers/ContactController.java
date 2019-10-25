package com.example.demo.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.FieldTypeCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Functions;
import com.example.demo.models.Contact;
import com.example.demo.models.Field;
import com.example.demo.models.User;
import com.example.demo.repositorys.ContactRepository;
import com.example.demo.repositorys.DepartmentRepository;
import com.example.demo.repositorys.FieldTypesRepository;
import com.example.demo.repositorys.FilledRepository;
import com.example.demo.repositorys.StateRepository;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.requestBody.ContactsRequestBody;
import com.example.demo.requestBody.ResponseModel;
import com.sun.istack.Nullable;

@RestController
public class ContactController {

	@Autowired
	Functions functions;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	FilledRepository fieldRepository;
	@Autowired
	FieldTypesRepository fieldTypeRepository;
	@Autowired
	DepartmentRepository depRepostiory;
	@Autowired
	UserRepository userRepostiory;
	@Autowired
	StateRepository stateRepository;
	
	
	
	@GetMapping("/api/getallcontact")
	ResponseEntity<Collection<Contact>> getallContact()
	{
		List<Contact> contacts = contactRepository.findAll();
		ResponseEntity<Collection<Contact>> response = new ResponseEntity<Collection<Contact>>(contacts,HttpStatus.OK);
		return response;
	}
	@GetMapping("/api/getContacts")
	ResponseEntity<ResponseModel> getContacts(@RequestHeader /* @Nullable */ String sessionKey)
	{
		return functions.getContacts(sessionKey);
	}
	@PostMapping("/api/addcontact")
	ResponseEntity<ResponseModel> addContact(@RequestBody ContactsRequestBody Body , @RequestHeader String sessionKey)
	{
		return functions.AddContact(sessionKey, Body);
	}
	@PostMapping("/api/updatecontact/{id}")
	ResponseEntity<ResponseModel> updateContact(@RequestBody ContactsRequestBody Body , @RequestHeader String sessionKey , @PathVariable int id)
	{
		return functions.UpdateContatct(sessionKey, id, Body);
	}
	@PostMapping("/api/deletecontact/{id}")
	ResponseEntity<ResponseModel> deleteContact(@RequestHeader String sessionKey , @PathVariable int id)
	{
		return functions.deleteContact(sessionKey, id);
	}
	@PostMapping("/api/waitingcontact")
	ResponseEntity<ResponseModel> waitingContact(@RequestHeader String sessionKey)
	{
		return functions.getWaitingContact(sessionKey);
	}
	@PostMapping("/api/changeContactState/{id}")
	ResponseEntity<ResponseModel> changeContactState(@RequestHeader String sessionKey , @PathVariable int id,int stateID)
	{
		return functions.changeContactState(sessionKey, id, stateID);
	}
}
