package com.example.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.LoginDTO;
import com.example.demo.service.LoginService;


@Controller
@RequestMapping("/")
public class LoginController {
	
	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	public LoginController() {
		logger.info("Created "+this.getClass().getSimpleName());
		logger.info("Object is created");
		logger.error("Error has occurred in application");
		logger.debug("This is deBug Message");
	}
	
	@RequestMapping("/")
	public String onLanding()
	{
		try {
		logger.info("Invoked onLanding() from "+this.getClass().getSimpleName());
		}
		catch (Exception e) {
			logger.error("error in onLoanding() from "+this.getClass().getSimpleName(),e);
		}
		return "Login";
	}
	
	@PostMapping("/login")
	public String onLogin(LoginDTO dto,Model model)
	{
		try {
		logger.info("Invoked onLogin() from "+this.getClass().getSimpleName());
		String check=null;
		logger.info("Dto is : "+dto);
		check=loginService.validateAndSave(dto);
		logger.info("Status is "+check);
		model.addAttribute("fname", "FirstName is <b>"+dto.getFirstName()+"</b>");
		model.addAttribute("lname","LastName is <b>"+ dto.getLastName()+"</b>");
		model.addAttribute("status", check);}
		catch (Exception e) {
			logger.error("Error in onLogin() from "+this.getClass().getSimpleName(),e);
		}
		return "Success";
	}

}
