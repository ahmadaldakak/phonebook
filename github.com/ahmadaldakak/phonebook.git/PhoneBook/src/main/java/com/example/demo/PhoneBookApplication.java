package com.example.demo;

import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example.demo.controllers" , "com.example.demo.repsitorys"})
public class PhoneBookApplication {
	
	@Bean
	public Singleton get_Singleton()
	{
		return new Singleton();
	}
	@Bean
	public Functions get_funcs()
	{
		return new Functions();
	}
	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApplication.class, args);
		 //givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect();
	}

}
