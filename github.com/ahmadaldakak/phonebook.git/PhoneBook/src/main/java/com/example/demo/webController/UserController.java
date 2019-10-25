package com.example.demo.webController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositorys.UserRepository;

@Controller
public class UserController {
@Autowired
UserRepository userRepository;



}
