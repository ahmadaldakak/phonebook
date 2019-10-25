package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Test;
import com.example.demo.repositorys.testRepository;

@Controller
public class TestController {

	@Autowired
	testRepository testrepo;
	
	
	@GetMapping("soukar")
	String getsoukar()
	{
		testrepo.save(new Test("soukar","065486494"));
		return "insertDepartment.jsp";
	}
	@PostMapping("soukar")
	String asdas()
	{
		System.out.print("post");
		return "insertDepartment.jsp";
	}
	
	
	
	
	
	
	
	
}
