package com.example.demo.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginEntity;
import com.example.demo.utility.SpringUtilClass;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SpringUtilClass util;
	
//	@Autowired
	private SessionFactory factory;
	
//	@Autowired
//	private EntityManagerFactory manFactory;
	private static final Logger log=Logger.getLogger(LoginDaoImpl.class);
	
	public LoginDaoImpl() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	@PostConstruct
	public void init()
	{
		factory=util.returnFactory();
	}
	
	@Override
	public String save(LoginEntity entity) {
		
		log.info("Invoked save() from "+this.getClass().getSimpleName());
		String result=null;
		Session session=factory.openSession(); 
		String name="Vinay";
		try {
//			String query="insert into lpg_login values('"+name+"','"+name+"','"+name+"');";
//			Query query=se
			session.beginTransaction();
//			
			session.save(entity);
			session.getTransaction().commit();
			result="data saved into database successfully";
		}catch (Exception e) {
			result="failed to save data";
			session.getTransaction().rollback();
			log.error("error occured in save() from "+this.getClass().getSimpleName());
		}finally {
			session.close();
			
		}
		return result;
	}
	
	

}
