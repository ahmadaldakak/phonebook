package com.example.demo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Contact;
import com.example.demo.models.ContactRequestBody;
import com.example.demo.models.Field;
import com.example.demo.models.Result;
import com.example.demo.models.Sessions;
import com.example.demo.models.User;
import com.example.demo.models.UserRequestbody;
import com.example.demo.models.field_types;
import com.example.demo.repositorys.ContactRepository;
import com.example.demo.repositorys.DepartmentRepository;
import com.example.demo.repositorys.FieldTypesRepository;
import com.example.demo.repositorys.FilledRepository;
import com.example.demo.repositorys.FunctionRepository;
import com.example.demo.repositorys.LogRepository;
import com.example.demo.repositorys.ResultRepository;
import com.example.demo.repositorys.SessionRepository;
import com.example.demo.repositorys.StateRepository;
import com.example.demo.repositorys.UserRepository;
import com.example.demo.repositorys.UserTypeRepository;
import com.example.demo.requestBody.ContactsRequestBody;
import com.example.demo.requestBody.FieldTypesResponseModel;
import com.example.demo.requestBody.ResponseModel;
import com.example.demo.requestBody.SignInRequestBody;
import com.example.demo.requestBody.SignInResponse;

@Component
public class Functions {

	@Autowired
	Singleton helper ;
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
	@Autowired 
	FieldTypesRepository fieldTypesRepository;
	@Autowired
	FilledRepository fieldRepository;
	@Autowired
	UserTypeRepository userTypeRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	StateRepository stateRepository;
	public ResponseEntity<ResponseModel> getFieldTypeById()
	{
		List<FieldTypesResponseModel> response = new ArrayList();
		List<field_types> list =fieldTypesRepository.findByparent(null);
		for(field_types field : list)
		{
			List<field_types> children =fieldTypesRepository.findByparent(field);
			response.add(new FieldTypesResponseModel(field, children));
		}
		return new ResponseEntity<ResponseModel>(new ResponseModel("ok", response), HttpStatus.OK);
	}
	
	public ResponseEntity<String> register(UserRequestbody body) throws NoSuchAlgorithmException
	{
		User user = new User();
		user.setBirthday(body.birthday);
		user.setName(body.name);
		user.setPassword(helper.HashPassword(body.password));
		user.setUserDepartment(departmentRepository.getOne(body.dep_id));
		user.setUserType(userTypeRepository.getOne(body.user_type_id));
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseModel> signin(SignInRequestBody request )	
	{
		List<User> users = userRepository.findByemail(request.getEmail());
		if(users.size() == 0)
		{
			//Result result =Helper.insertLog(1, 3, 0);
			return new ResponseEntity<ResponseModel>(new ResponseModel(resultRepository.getOne(1).getResult_text(),null),HttpStatus.NOT_FOUND);
		}
		User user = users.get(0);
		if(!user.getPassword().equals(request.getPassword()))
		{
			//Result result =Helper.insertLog(1, 3, user.getUser_id());
			return new ResponseEntity<ResponseModel>(new ResponseModel(resultRepository.getOne(1).getResult_text(), null),HttpStatus.NOT_FOUND);
		}
		Result result = helper.insertLog(user.getUser_id(), 3, 1);
		String SessionKey = helper.gensession(user.getEmail());
		sessionRepository.save(new Sessions(user,SessionKey,1));
		SignInResponse responseBody = new SignInResponse(SessionKey, user);
		
		return new ResponseEntity<ResponseModel>(new ResponseModel(result.getResult_text(),responseBody),HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> getContacts(String sessionKey)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		List<Contact> contacts = contactRepository.findByContactDepartmentAndState(user.getUserDepartment() , stateRepository.getOne(1));
		return new ResponseEntity<ResponseModel>(new ResponseModel("success",contacts), HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> AddContact(String sessionKey , ContactsRequestBody Body)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		Contact contact = new Contact();
		contact.setBirthday(Body.getBirthday());
		contact.setImage(Body.getImage());
		contact.setAddress(Body.getAddress());
		contact.setName(Body.getName());
		contact.setContactDepartment(user.getUserDepartment());
		contact.setContactUser(user);
		contact.setState(stateRepository.getOne(2));
		int id = contactRepository.save(contact).getId();
		for (int i = 0; i < Body.getFilled().size(); i++) {
			Field f = new Field();
			f.setFieldContact(contactRepository.getOne(id));
			f.setField_type(fieldTypesRepository.getOne(Body.getFilled().get(i).getType()));
			f.setContent(Body.getFilled().get(i).getContent());
			fieldRepository.save(f);
		}
		return new ResponseEntity<ResponseModel>(new ResponseModel("", null),HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseModel> Logout(String sessionKey)
	{
		List<Sessions> session = sessionRepository.findBysessionKey(sessionKey);
		if(session.size()>0)
		{
			Sessions s = sessionRepository.getOne(session.get(0).getId());
			s.setIs_active(0);
			sessionRepository.save(s);
			boolean t = true;
			return new ResponseEntity<ResponseModel>(new ResponseModel("", t),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseModel>(new ResponseModel("", false),HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseModel> UpdateContatct(String sessionKey , int id ,  ContactsRequestBody Body)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		Contact contact = contactRepository.getOne(id);
		if(contact.getContactDepartment().getId() != user.getUserDepartment().getId())
		{
			
		}
		contact.setBirthday(Body.getBirthday());
		contact.setImage(Body.getImage());
		contact.setAddress(Body.getAddress());
		contact.setName(Body.getName());
		contact.setState(stateRepository.getOne(2));
		contact.getFields().clear();
		fieldRepository.deleteByfieldContact(contact);
		for (int i = 0; i < Body.getFilled().size(); i++) {
			Field f = new Field();
			f.setFieldContact(contact);
			f.setField_type(fieldTypesRepository.getOne(Body.getFilled().get(i).getType()));
			f.setContent(Body.getFilled().get(i).getContent());
			fieldRepository.save(f);
		}
		return new ResponseEntity<ResponseModel>(new ResponseModel("", null),HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> deleteContact(String sessionKey , int id)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		Contact contact = contactRepository.getOne(id);
		if(contact.getContactDepartment().getId() != user.getUserDepartment().getId())
		{
			
		}
		contactRepository.delete(contact);
		return new ResponseEntity<ResponseModel>(HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> getWaitingContact(String sessionKey )
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		if(user.getUserType().getId()!=1)
		{
			
		}
		List<Contact> contacts =contactRepository.findByState(stateRepository.getOne(2));
		return new ResponseEntity<ResponseModel>(new ResponseModel("Success", contacts),HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> changeContactState(String sessionKey , int contactId , int stateID)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		if(user.getUserType().getId()!=1)
		{
			
		}
		Contact contact = contactRepository.getOne(contactId);
		contact.setState(stateRepository.getOne(stateID));
		contactRepository.save(contact);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	public ResponseEntity<ResponseModel> getContact(String sessionKey ,int id)
	{
		User user = helper.checkSession(sessionKey);
		if(user == null) return helper.notAuthUser();
		Contact contact = contactRepository.getOne(id);
		if(contact.getContactDepartment().getId() != user.getUserDepartment().getId())
		{
			
		}
		return new ResponseEntity<ResponseModel>(new ResponseModel("Success", contact),HttpStatus.OK);
	}
}
