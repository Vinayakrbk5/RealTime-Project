package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.LoginEntity;

@SpringBootTest
class Demo1ApplicationTests {
	@Autowired
	LoginDAO loginDao;
	
	private static final Logger log=Logger.getLogger(Demo1Application.class);

	@BeforeAll
	public static void beforeAll()
	{
		log.info("Invoked beforeAll() from Demo1ApplicationTests class");
		
	}
	
	@BeforeEach
	public void beforeEach()
	{
		log.info("Invoked beforeEach() from Demo1ApplicationTests class");
	}
	
	@Test
	void checkingLoginDaoImpl() {
		log.info("Invoked checkingLoginDaoImpl() test method");
		String str="data saved into database successfully";
		String str2=null;
		LoginEntity entity=new LoginEntity();
		
		str2=loginDao.save(entity);
		assertEquals(str, str2);
		
	}
	
	@Test
	void checkingServiceDaoImpl()
	{
		log.info("Invoked checkingServiceDaoImpl() test method");
		String str="data saved into database successfully";
		String str2=null;
		LoginEntity entity=new LoginEntity();
		str2=loginDao.save(entity);
		assertNotEquals(str, str2,"here both expected and actual values are equal");
		
	}
	
	@AfterEach
	public void afterEach() {
		log.info("Invoked afterEach() from Demo1ApplicationTests class");
	}
	
	@AfterAll
	public static void afterAll() {
		log.info("Invoked afterAll() from Demo1ApplicationTests class");
	}

}
