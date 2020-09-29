package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jboss.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="LPG_LOGIN")
@Data
@AllArgsConstructor
public class LoginEntity {
	
	private static final Logger log=Logger.getLogger(LoginEntity.class);
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="PERSON_ID")
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	
	public LoginEntity() {
		log.info("Created "+this.getClass().getSimpleName());
	}
	
	

}
