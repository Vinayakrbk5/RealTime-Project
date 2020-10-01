package com.example.demo.dto;

import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
	
	private static final Logger logger=Logger.getLogger(LoginDTO.class);
	
	private String firstName;
	private String lastName;
	
	public LoginDTO() {
		logger.info("Created "+this.getClass().getSimpleName());
	}

}
