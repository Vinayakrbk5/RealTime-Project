package com.example.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.LoginService;


@Controller
@RequestMapping("/")
public class LoginController {
	
	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	public LoginController() {
		System.out.println("Created "+this.getClass().getSimpleName());
		logger.info("Object is created");
		logger.error("Error has occurred in application");
		logger.debug("This is deBug Message");
	}
	
	@RequestMapping("/")
	public String onLanding()
	{
		System.out.println("Invoked onLanding()");
		return "Login";
	}
	
	@PostMapping("/login")
	public String onLogin(LoginDto dto,Model model)
	{
		logger.info("Invoked onLogin()");
		String check=null;
		System.out.println("Dto is : "+dto);
		check=loginService.validateAndSave(dto);
		System.out.println("Status is "+check);
		model.addAttribute("fname", "FirstName is "+dto.getFirstName());
		model.addAttribute("lname","LastName is "+ dto.getLastName());
		model.addAttribute("status", check);
		return "Success";
	}

}
