package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDAO;
import com.example.demo.dto.EnvironmentDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.EnvironmentEntity;
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
	public String validateAndSave(LoginDTO dto, List<EnvironmentDTO> envList) {
		log.info("Invoked validateAndSave() in LoginServiceImpl");
		LoginEntity loginEntity=new LoginEntity();
		List<EnvironmentEntity> envEntitySList=new ArrayList<>();
		String name=null;
		try {
			if(Objects.nonNull(dto))
			{
				log.info("Dto is not null");
				{
					ModelMapper mapper=new ModelMapper();
					mapper.map(dto, loginEntity);
					
					for(EnvironmentDTO env:envList) {
						
						EnvironmentEntity envEntity=new EnvironmentEntity();
						mapper.map(env, envEntity);
						envEntity.setLoginEntity(loginEntity);
						envEntitySList.add(envEntity);
					}
					
					loginEntity.setEntity(envEntitySList);
					
//					BeanUtils.copyProperties(dto, entity);
//					log.info("FirstName and LastName are valid");
					log.info("Entity is : "+loginEntity);
					
					name=loginDao.save(loginEntity,envEntitySList);
				}
			}
		}catch (Exception e) {
			log.error("Error Occured in validateAndSave() in "+this.getClass().getSimpleName(),e);
		}
		return name;
		
	}

}
