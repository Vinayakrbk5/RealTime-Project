package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="PROJECT_DETAILS")
@Data
@AllArgsConstructor
public class LoginEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(LoginEntity.class);
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="PROJECT_ID")
	private int projectId;
	@Column(name="PROJECT_NAME")
	private String projectName;
	@Column(name="TEAM_MANAGER_NAME")
	private String TeamManagerName;
	@Column(name="CONTACT_EMAIL")
	private String email;
	@Column(name="IS_DE_COMMISSIONED")
	private String isDeComisioned;
	@Column(name="DEVELOPED_DATE")
	private String developedDate;
	@Column(name="VERSION")
	private String version;
	@Column(name="LAST_RELEASE")
	private String lastRelease;
	@Column(name="NEXT_RELEASE")
	private String nextRelease;
	
	@OneToMany(mappedBy = "loginEntity")
	private List<EnvironmentEntity> entity;
	
	public LoginEntity() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	

}
