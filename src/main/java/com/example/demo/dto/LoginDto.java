package com.example.demo.dto;

import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
	
	private static final Logger logger=Logger.getLogger(LoginDto.class);
	
	private String firstName;
	private String lastName;
	
	public LoginDto() {
		logger.info("Created "+this.getClass().getSimpleName());
	}

}
