package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.example.demo.Functions;
import com.example.demo.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Singleton;
import com.example.demo.models.Log;
import com.example.demo.models.Result;
import com.example.demo.models.Sessions;
import com.example.demo.models.User;
import com.example.demo.repositorys.DepartmentRepository;
import com.example.demo.repositorys.FunctionRepository;
import com.example.demo.repositorys.LogRepository;
import com.example.demo.repositorys.ResultRepository;
import com.example.demo.repositorys.SessionRepository;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.requestBody.ResponseModel;
import com.example.demo.requestBody.SignInRequestBody;
import com.example.demo.requestBody.SignInResponse;

@RestController
public class AuthenticationController {

	@Autowired
	Singleton helper;
	@Autowired
	Functions functions;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ResultRepository resultRepository;
	@Autowired
	LogRepository logRepository;
	@Autowired
	FunctionRepository functionRepository;
	@Autowired
	SessionRepository sessionRepository;
	@PostMapping("/api/signIn")
	ResponseEntity<ResponseModel> signin(@RequestBody SignInRequestBody request )	
	{
		return functions.signin(request);
	}

}