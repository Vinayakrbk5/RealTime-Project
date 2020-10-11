package com.example.demo.excel_conversion;

import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EnvironmentDTO;
import com.example.demo.dto.LoginDTO;

@Component
public class ExcelToDTOConverter {
	
	private static final Logger log=Logger.getLogger(ExcelToDTOConverter.class);
	
	public Set<Set<EnvironmentDTO>> sendSetOfSet(String fileName) {
		
		log.info("Invoked ExcelToDTOConverter() from "+this.getClass().getSimpleName());
		Set<Set<EnvironmentDTO>> setOfSet=new LinkedHashSet<Set<EnvironmentDTO>>();
		Set<EnvironmentDTO> set=new LinkedHashSet<EnvironmentDTO>();
		System.out.println("Hello world");
		try {
			FileInputStream file = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			
			Row row;
			String num="1.0";
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				String id;
				if (row.getCell(0) == null) {
					id = "0";
				} else {
					id = row.getCell(0).toString();
					
				}

				String envValue;

				if (row.getCell(1) == null) {
					envValue = null;
				} else {
					envValue = row.getCell(1).toString();
				}

				String url;
				if (row.getCell(2) == null) {
					url = "0";
				} else {
					url = row.getCell(2).toString();
				}
				
				
				EnvironmentDTO envDTO=new EnvironmentDTO();
				envDTO.setEnvValue(envValue);
				envDTO.setUrl(url);
				
				System.out.println("set is : "+set);
				if(num.equals(id)) {
					set.add(envDTO);
					setOfSet.add(set);
				}else {
					setOfSet.add(set);
					set=new LinkedHashSet<EnvironmentDTO>();
					set.add(envDTO);
					num=id;
				}
			}
			
			System.out.println("***************************************");
			System.out.println("List elements are :");
			setOfSet.forEach(p->System.out.println(p));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return setOfSet;
	}

	public Set<LoginDTO> sendSet(String fileName)
	{
		log.info("Invoked sendSet() from "+this.getClass().getSimpleName());
		Set<LoginDTO> set=new LinkedHashSet<LoginDTO>();
		try {
			FileInputStream file = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			

			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				String projectName;
				if (row.getCell(0) == null) {
					projectName = "0";
				} else {
					projectName = row.getCell(0).toString();
				}
				System.out.println("projectName is :"+projectName);

				String TeamManagerName;

				if (row.getCell(1) == null) {
					TeamManagerName = null;
				} else {
					TeamManagerName = row.getCell(1).toString();
				}
				System.out.println("TeamManagerName is :"+TeamManagerName);

				String email;
				if (row.getCell(2) == null) {
					email = "0";
				} else {
					email = row.getCell(2).toString();
				}
				
				System.out.println("email is :"+email);
				
				String isDeComisioned;
				if (row.getCell(3) == null) {
					isDeComisioned = "0";
				} else {
					isDeComisioned = row.getCell(3).toString();
				}
				
				System.out.println("isDeComisioned is :"+isDeComisioned);
				
				String developedDate;
				if (row.getCell(4) == null) {
					developedDate = "0";
				} else {
					developedDate = row.getCell(4).toString();
				}
				
				System.out.println("developedDate is :"+developedDate);
				
				String version;
				if (row.getCell(5) == null) {
					version = "0";
				} else {
					version = row.getCell(5).toString();
				}
				
				System.out.println("version is :"+version);
				
				String lastRelease;
				if (row.getCell(6) == null) {
					lastRelease = "0";
				} else {
					lastRelease = row.getCell(6).toString();
				}
				
				System.out.println("lastRelease is :"+lastRelease);
				
				String nextRelease;
				if (row.getCell(7) == null) {
					nextRelease = "0";
				} else {
					nextRelease = row.getCell(7).toString();
				}
				
				System.out.println("nextRelease is :"+nextRelease);
				
				String creationTime;
				if (row.getCell(8) == null) {
					creationTime = "0";
				} else {
					creationTime = row.getCell(8).toString();
				}
				
				System.out.println("creationTime is :"+creationTime);
				
				String createdBy;
				if (row.getCell(9) == null) {
					createdBy = "0";
				} else {
					createdBy = row.getCell(9).toString();
				}
				
				System.out.println("createdBy is :"+createdBy);
				
				String updateTime;
				if (row.getCell(10) == null) {
					updateTime = "0";
				} else {
					updateTime = row.getCell(10).toString();
				}
				
				System.out.println("updateTime is :"+updateTime);
				
				String updatedBy;
				if (row.getCell(11) == null) {
					updatedBy = "0";
				} else {
					updatedBy = row.getCell(11).toString();
				}
				
				System.out.println("updatedBy is :"+updatedBy);
				
				
				LoginDTO loginDto=new LoginDTO();
				loginDto.setProjectName(projectName);
				loginDto.setTeamManagerName(TeamManagerName);
				loginDto.setEmail(email);
				loginDto.setIsDeComisioned(Boolean.parseBoolean(isDeComisioned));
				loginDto.setDevelopedDate(developedDate);
				loginDto.setVersion(version);
				loginDto.setLastRelease(lastRelease);
				loginDto.setNextRelease(nextRelease);
				loginDto.setCreationTime(creationTime);
				loginDto.setCreatedBy(createdBy);
				loginDto.setUpdateTime(updateTime);
				loginDto.setUpdatedBy(updatedBy);
				set.add(loginDto);
			}
			
			log.info("List elements are :");
			set.forEach(p->System.out.println(p));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}

}
