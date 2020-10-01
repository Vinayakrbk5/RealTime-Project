package com.example.demo.service;

import java.util.Objects;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDAO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.LoginEntity;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDao;
	
	private static final Logger log=Logger.getLogger(LoginServiceImpl.class);
	public LoginServiceImpl() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	@Override
	public String validateAndSave(LoginDTO dto) {
		log.info("Invoked validateAndSave() in LoginServiceImpl");
		LoginEntity entity=new LoginEntity();
		String name=null;
		try {
			if(Objects.nonNull(dto))
			{
				log.info("Dto is not null");
				if(!dto.getFirstName().isEmpty() && !dto.getLastName().isEmpty())
				{
					ModelMapper mapper=new ModelMapper();
					mapper.map(dto, entity);
//					BeanUtils.copyProperties(dto, entity);
					log.info("FirstName and LastName are valid");
					log.info("Entity is : "+entity);
					name=loginDao.save(entity);
				}
			}
		}catch (Exception e) {
			log.error("Error Occured in validateAndSave() in "+this.getClass().getSimpleName(),e);
		}
		return name;
		
	}

}
