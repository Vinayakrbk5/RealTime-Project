package com.example.demo.utility;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SpringUtilClass {
	@Autowired
	private EntityManagerFactory factory;
	
//	@Bean
	public SessionFactory returnFactory()
	{
		System.out.println("Factory value is : "+factory);
		return factory.unwrap(SessionFactory.class);
		 
	}

}
