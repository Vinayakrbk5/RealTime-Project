package com.example.demo.dto;

import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;

//@Data
@AllArgsConstructor
public class EnvironmentDTO {
	
	private String envValue;
	private String url;
	
	final static private Logger log=Logger.getLogger(EnvironmentDTO.class);
	public EnvironmentDTO() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	
	public String getEnvValue() {
		return envValue;
	}


	public void setEnvValue(String envValue) {
		this.envValue = envValue;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "EnvironmentDTO [envValue=" + envValue + ", url=" + url + "]";
	}
	
}
