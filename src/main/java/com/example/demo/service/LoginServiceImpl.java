package com.example.demo.service;

import java.util.Objects;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.LoginEntity;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;
	
	private static final Logger log=Logger.getLogger(LoginServiceImpl.class);
	public LoginServiceImpl() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	@Override
	public String validateAndSave(LoginDto dto) {
		log.info("Invoked validateAndSave() in LoginServiceImpl");
		LoginEntity entity=new LoginEntity();
		String name=null;
		try {
			if(Objects.nonNull(dto))
			{
				log.info("Dto is not null");
				if(!dto.getFirstName().isEmpty() && !dto.getLastName().isEmpty())
				{
					
					BeanUtils.copyProperties(dto, entity);
					log.info("FirstName and LastName are valid");
					log.info("Entity is : "+entity);
					name=loginDao.save(entity);
				}
			}
		}catch (Exception e) {
			log.error("Error Occured in validateAndSave() in "+this.getClass().getSimpleName());
		}
		return name;
		
	}

}
