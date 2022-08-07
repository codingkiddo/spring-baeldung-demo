package com.spring.quickstarts.services.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.spring.quickstarts.services.GreetService;

@Service
@Configuration
public class GreetServiceImpl implements GreetService {

	@Autowired
	private DataSource dataSource;
	
	public String getGreet(String name) {
		System.out.println(this.dataSource);
		if(name == null) {
			return "greet";
		} else {
			return "greet";
		}
	}
	
	@Bean(name = "greetService")
	public GreetService getGreetService() {
		return new GreetServiceImpl();
	}
	
}
