package com.example.demo.dto;

import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;

//@Data
@AllArgsConstructor
public class EnvironmentDTO {
	
	private Integer slNo;
	private String envValue;
	private String url;
	
	final static private Logger log=Logger.getLogger(EnvironmentDTO.class);
	public EnvironmentDTO() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	public Integer getSlNo() {
		return slNo;
	}
	
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
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
		return "EnvironmentDTO [slNo=" + slNo + ", envValue=" + envValue + ", url=" + url + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.envValue.equals(((EnvironmentDTO)obj).envValue);
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	
}
