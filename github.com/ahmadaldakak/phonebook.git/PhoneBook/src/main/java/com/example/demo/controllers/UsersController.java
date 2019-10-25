package com.example.demo.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Functions;
import com.example.demo.Singleton;
import com.example.demo.models.Sessions;
import com.example.demo.models.User;
import com.example.demo.models.UserRequestbody;
import com.example.demo.repositorys.DepartmentRepository;
import com.example.demo.repositorys.ResultRepository;
import com.example.demo.repositorys.SessionRepository;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.repositorys.UserTypeRepository;
import com.example.demo.requestBody.ResponseModel;

@RestController
public class UsersController {

	@Autowired
	Singleton helper ;
	@Autowired
	Functions functions;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository depRepository;
	@Autowired
	UserTypeRepository userStateRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	ResultRepository resultRepository;
	
	
	@GetMapping("api/getusers")
	ResponseEntity<Collection<User>> getAllUsers() {
	List<User> users = userRepository.findAll();
	System.out.print("Hello : "+users.size());
	Map <Integer,User> body = new HashMap();
	for(User u : users)
		{
		body.put(u.getUser_id(), u);
		}
	
;	ResponseEntity<Collection<User>> response = new ResponseEntity<Collection<User>>(body.values(),HttpStatus.OK); 
	return response ;
	}
	
	@GetMapping("api/getuser/{id}")
	ResponseEntity<User> getuser(@PathVariable int id)
	{
		User user = userRepository.getOne(id);
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getUser_id());
		System.out.println(user.getBirthday());
		System.out.println(user.getUserDepartment().getName());
		System.out.println(user.getUserType().getType_name());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("api/getuserr/{id}")
	ResponseEntity<ResponseModel> getuserr(@PathVariable int id)
	{
		User user = userRepository.getOne(id);
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getUser_id());
		System.out.println(user.getBirthday());
		System.out.println(user.getUserDepartment().getName());
		System.out.println(user.getUserType().getType_name());
		ResponseModel response = new ResponseModel();
		response.setData(user);
		return new ResponseEntity<ResponseModel>(response,HttpStatus.OK);
	}
	
	
	@PostMapping("api/register")
	ResponseEntity<String> register(@RequestBody UserRequestbody body) throws NoSuchAlgorithmException
	{
		return functions.register(body);
	}
	
	@GetMapping("api/myuser")
	ResponseEntity<ResponseModel> getMyUser(@RequestHeader(name = "sessionKey") String sessionKey )
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();		
		return new ResponseEntity<ResponseModel>(new ResponseModel("", user),HttpStatus.OK);
	}
}
