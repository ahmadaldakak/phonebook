package com.example.demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
import com.sun.istack.Nullable;

@Component
public class Singleton {
	
	
	
	
	public Singleton() {
	}
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

	public Result insertLog(int fun , int res,@Nullable int user)
	{
		Log log = new Log();
		if(user != 0)
		log.setLoguser(userRepository.getOne(user));
		Result result = resultRepository.getOne(3);
		log.setLogResult(result);
		log.setDatetime(new Date());
		log.setLogfunction(functionRepository.getOne(1));
		System.out.println(log);
		logRepository.save(log);
		return result;
	}
	public void test()
	{
		System.out.println(userRepository);
	}
	
	
	public User checkSession(String sessionKey)
	{
		List<Sessions> list = sessionRepository.findBysessionKey(sessionKey);
		if(list.size() != 0)
		{
			Sessions mySession = list.get(0);
			if (mySession.getIs_active()==0)
				return null;	
			else return mySession.getSessionUser();
		}
		return null;
	}
	
	
	public User checkAdvanceSession(String sessionKey)
	{
		List<Sessions> list = sessionRepository.findBysessionKey(sessionKey);
		if(list.size() != 0)
		{
			Sessions mySession = list.get(0);
			if (mySession.getIs_active()==0)
				return null;	
			else return mySession.getSessionUser();
		}
		return null;
	}
	
	
	
	public ResponseEntity<ResponseModel> notAuthUser()
	{
		return new ResponseEntity<ResponseModel>(new ResponseModel(resultRepository.getOne(4).getResult_text(), null),HttpStatus.UNAUTHORIZED);
	}
	public String HashPassword(String Password) throws NoSuchAlgorithmException
	{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
		messageDigest.update(Password.getBytes(),0, Password.length());  
		String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
		if (hashedPass.length() < 32) {
		   hashedPass = "0" + hashedPass; 
		}
		return hashedPass;
	}
	public String gensession(String email) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 90;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return generatedString+email;
	}
}
