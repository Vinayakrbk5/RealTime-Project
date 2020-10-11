package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.EnvironmentDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	private List<EnvironmentDTO> envList;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	public LoginController() {
		logger.info("Created " + this.getClass().getSimpleName());
		logger.info("Object is created");
		logger.error("Error has occurred in application");
		logger.debug("This is deBug Message");
	}

	@PostConstruct
	public void init() {
		logger.info("Invoked init() from Loginontroller");
		envList = new ArrayList<>();
	}

	@RequestMapping("/")
	public String onLanding() {
		try {
			logger.info("Invoked onLanding() from " + this.getClass().getSimpleName());
		} catch (Exception e) {
			logger.error("error in onLoanding() from " + this.getClass().getSimpleName(), e);
		}
		return "Login";
	}

	@PostMapping("/login")
	public String onLogin(LoginDTO dto, Model model) {
		try {
			logger.info("Invoked onLogin() from " + this.getClass().getSimpleName());
			String check = null;
			logger.info("Dto is : " + dto);
			check = loginService.validateAndSave(dto, envList);
			envList.removeAll(envList);
			logger.info("Status is " + check);
			model.addAttribute("status", check);
		} catch (Exception e) {
			logger.error("Error in onLogin() from " + this.getClass().getSimpleName(), e);
		}
		return "Login";
	}

	@PostMapping("addEnv")
	public ResponseEntity<Object> onAdding(@RequestBody List<EnvironmentDTO> list) {
		logger.info("Invoked onAdding() from " + this.getClass().getSimpleName());

//		logger.info("Env name : "+envDto.getEnvValue());
//		logger.info("Url : "+envDto.getUrl());
//		envList.add(envDto);
//		envList.forEach(p->System.out.println(p));
		System.out.println("List is : " + list);
		envList = list;

		return ResponseEntity.ok().body("Success");
	}

	@RequestMapping("/bulksave")
	public String saveBulkData(@RequestParam String fileName, Model model) {
		logger.info("Invoked saveBulkData() from " + this.getClass().getSimpleName());
		String status = null;
		status = loginService.validateAndSaveBulkData(fileName);
		model.addAttribute("status", status);
		return "Login";

	}

}
