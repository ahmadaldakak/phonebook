package com.example.demo.controllers;

import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Functions;
import com.example.demo.Singleton;
import com.example.demo.models.Contact;
import com.example.demo.models.User;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.requestBody.ResponseModel;
import com.example.demo.requestBody.SignInRequestBody;
import com.example.demo.requestBody.SignInResponse;
@Controller
public class UserWebController {
@Autowired
UserRepository userRepository;
@Autowired
Functions functions;
@Autowired
Singleton helper;


@GetMapping("home")
public ModelAndView homePage(HttpSession httpSession ,@CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey)
{
	User user = helper.checkSession(sessionKey);
	if (user != null) {
		ModelAndView model = new ModelAndView();
		model.addObject("User", user);
		model.setViewName("home");
		return model;
	}
	ModelAndView model = new ModelAndView();
	model.setViewName("redirect:/login");
	return model;
}

@GetMapping({"/","/login"})
public ModelAndView GetLogin(@CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey,HttpServletRequest  httpSession) {

	System.out.print(sessionKey);
	User user = helper.checkSession(sessionKey);
	if (user != null) {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/home");
		return model;
	}
	ModelAndView model = new ModelAndView();
	model.setViewName("Login");
	return model;
}


@GetMapping("createcontact")
public ModelAndView createContact(@CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey)
{
	System.out.print(sessionKey);
	User user = helper.checkSession(sessionKey);
	if (user != null) {
		ModelAndView model = new ModelAndView();
		model.addObject("User", user);
		model.setViewName("CreateContact");
		return model;
	}
	ModelAndView model = new ModelAndView();
	model.setViewName("Login");
	return model;
}





@GetMapping("logout")
public ModelAndView logout(@CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey)
{
	ModelAndView m = new ModelAndView();
	
	System.out.print(sessionKey);
	User user = helper.checkSession(sessionKey);
	if (user!=null) {
		functions.Logout(sessionKey);
		m.setViewName("redirect:/login");
		return m;
		
	}
	m.setViewName("redirect:/login");
	return m;
}

@PostMapping("/login")
private ModelAndView PostLogin(String email ,String password , HttpServletResponse httpSession) {
	ModelAndView model = new ModelAndView();
	SignInRequestBody request = new SignInRequestBody(email, password);
	ResponseEntity<ResponseModel> respone = functions.signin(request);
	ResponseModel returnValue = respone.getBody();
	if(returnValue.getData()==null)
	{
		model.addObject("massage", returnValue.getMassage());
		model.setViewName("Login");
		return model;
	}
	SignInResponse user = (SignInResponse) returnValue.getData();
	httpSession.addCookie(new Cookie("sessionKey", user.getSessionKey()));
	model.addObject("User", user.getUser());
	model.setViewName("redirect:/home");
	
	return model;
}

@RequestMapping("/viewcontact")
public ModelAndView viewContact(@RequestParam("id") int id,@CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey)
{
	ModelAndView model = new ModelAndView();
	ResponseEntity<ResponseModel> respone = functions.getContact(sessionKey, id);
	if(respone.getBody().getData()!=null)
	{
		Contact contact = (Contact) respone.getBody().getData();
		User user = helper.checkSession(sessionKey);
		model.addObject("contact", contact);
		model.addObject("User", user);
		model.setViewName("viewContact");
		return model;
	}
	model.setViewName("redirect:login");
	return model;
}

@GetMapping("/allcontact")
public ModelAndView getAllContacts(  @CookieValue(value = "sessionKey", defaultValue = "Atta")  String sessionKey)
{
	ModelAndView model = new ModelAndView();
	ResponseEntity<ResponseModel> respone = functions.getContacts(sessionKey);
	if(respone.getBody().getData()!=null)
	{
		List<Contact> contacts = (List<Contact>) respone.getBody().getData();
		User user = helper.checkSession(sessionKey);
		model.addObject("cotacts", contacts);
		model.addObject("User", user);
		model.setViewName("AllContacts");
		return model;
	}
	model.setViewName("redirect:login");
	return model;
}

}
