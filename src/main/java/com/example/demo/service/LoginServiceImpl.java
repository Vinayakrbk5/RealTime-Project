package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import com.example.demo.excel_conversion.ExcelToDTOConverter;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDao;
	
	@Autowired
	private ExcelToDTOConverter excelToDtoConverter;
	
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
		Date date=new Date();
		dto.setCreatedBy("vinayak");
		dto.setCreationTime(date.toString());
		dto.setUpdatedBy("Vinayak");
		dto.setUpdateTime(date.toString());
		try {
			if(Objects.nonNull(dto))
			{
				log.info("Dto is not null");
				{
					ModelMapper mapper=new ModelMapper();
					mapper.map(dto, loginEntity);
					System.out.println("Dto is : "+dto);
					System.out.println("Entity is : "+loginEntity);
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
					
					name=loginDao.save(loginEntity);
				}
			}
		}catch (Exception e) {
			log.error("Error Occured in validateAndSave() in "+this.getClass().getSimpleName(),e);
		}
		return name;
		
	}
	
	@Override
	public String validateAndSaveBulkData(String url) {
		try {
		log.info("Invoked validateAndSaveBulkData() from "+this.getClass().getSimpleName());
		ModelMapper mapper=new ModelMapper();
		Set<Set<EnvironmentDTO>> setOfSetData=new LinkedHashSet<Set<EnvironmentDTO>>();
		Set<LoginDTO> setData=new LinkedHashSet<LoginDTO>();
		setData=excelToDtoConverter.sendSet(url);
		setOfSetData =excelToDtoConverter.sendSetOfSet(url);
		
		
		LoginDTO loginDto=new LoginDTO();
		List<EnvironmentDTO> envList=new ArrayList<>();
		
		List<LoginDTO> arrList=new ArrayList<LoginDTO>(setData);
		List<List<EnvironmentDTO>> arrListOfList=new ArrayList<List<EnvironmentDTO>>();
		for(Set<EnvironmentDTO> aList:setOfSetData)
		{
			List<EnvironmentDTO> list1=new ArrayList<EnvironmentDTO>(aList);
			arrListOfList.add(list1);
		}
		
		for(int i=0, j=0;i<arrList.size() && j<arrListOfList.size();i++,j++)
		{
		System.out.println("List "+i+" is "+arrList.get(i));
		System.out.println("List of List "+j+" is :"+arrListOfList.get(j));
		loginDto=arrList.get(i);
		envList=arrListOfList.get(j);
		LoginEntity loginEntity=new LoginEntity();
		List<EnvironmentEntity> entityList=new ArrayList<>();
		mapper.map(loginDto, loginEntity);
		for(EnvironmentDTO dto:envList)
		{
			EnvironmentEntity envEntity=new EnvironmentEntity();
			mapper.map(dto, envEntity);
			envEntity.setLoginEntity(loginEntity);
			entityList.add(envEntity);
			
		}
		loginEntity.setEntity(entityList);
		loginDao.save(loginEntity);
		}
		
		}
		catch (Exception e) {
			log.info("Error in validateAndSaveBulkData() from "+this.getClass().getSimpleName(),e);
		}
		return null;
	}

}
