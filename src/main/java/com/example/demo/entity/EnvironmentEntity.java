package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;

//@Data
@AllArgsConstructor
@Entity
@Table(name="ENIRONMENT_TABLE")
public class EnvironmentEntity implements Serializable{
	
	final static private Logger log=Logger.getLogger(EnvironmentEntity.class);
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="ENV_ID")
	private Integer envId;
	@Column(name="ENV_TYPE")
	private String envValue;
	@Column(name="ENV_URL")
	private String url;

	@ManyToOne
	@JoinColumn(name="projectId")
	private LoginEntity loginEntity;
	
	public EnvironmentEntity() {
		log.info("Created "+this.getClass().getSimpleName());
	}

	public Integer getEnvId() {
		return envId;
	}

	public void setEnvId(Integer envId) {
		this.envId = envId;
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

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}

	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
	
	

}
