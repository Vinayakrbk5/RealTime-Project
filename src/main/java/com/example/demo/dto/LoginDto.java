package com.example.demo.dto;


import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
	
	private static final Logger logger=Logger.getLogger(LoginDTO.class);
	
	private String projectName;
	private String TeamManagerName;
	private String email;
	private Boolean isDeComisioned;
	private String developedDate;
	private String version;
	private String lastRelease;
	private String nextRelease;
	private String creationTime;
	private String createdBy;
	private String updateTime;
	private String updatedBy;
	
	public LoginDTO() {
		logger.info("Created "+this.getClass().getSimpleName());
	}

}
