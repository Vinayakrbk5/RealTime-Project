package com.example.demo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EnvironmentEntity;
import com.example.demo.entity.LoginEntity;
import com.example.demo.utility.SpringUtilClass;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	private SpringUtilClass util;
	
//	@Autowired
	private SessionFactory factory;
	
//	@Autowired
//	private EntityManagerFactory manFactory;
	private static final Logger log=Logger.getLogger(LoginDAOImpl.class);
	
	public LoginDAOImpl() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	@PostConstruct
	public void init()
	{
		log.info("Invoked init()");
		factory=util.returnFactory();
	}
	
	@Override
	public String save(LoginEntity entity,List<EnvironmentEntity> envSet) {
		
		log.info("Invoked save() from "+this.getClass().getSimpleName());
		String result=null;
		Session session=factory.openSession(); 
//		String name="Vinay";
		try {
//			String query="insert into lpg_login values('"+name+"','"+name+"','"+name+"');";
//			Query query=se
			session.beginTransaction();
			session.save(entity);
			System.out.println("Started For loop");
			System.out.println("List is : "+envSet);
			for(EnvironmentEntity ent:envSet)
			{
				System.out.println("Entity is : "+ent);
				session.save(ent);
			}
			System.out.println("End of for loop");
			session.getTransaction().commit();
			result="data saved into database successfully";
		}catch (Exception e) {
			result="failed to save data";
			session.getTransaction().rollback();
			log.error("error occured in save() from "+this.getClass().getSimpleName(),e);
		}finally {
			session.close();
			
		}
		return result;
	}
	
	

}
