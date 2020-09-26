package com.xworkz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
	
	public LoginController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping("login")
	public String onLogin()
	{
		System.out.println("Invoked onLogin()");
//		model.addObject("name",name);
//		model.setViewName("entry");
//		return "entry.html";
		return "login.jsp";
	}
	
	@RequestMapping("entry")
	public String onEntry(@RequestParam String name1,@RequestParam String message,Model model)
	{
		System.out.println("Invoked onEntry()");
		System.out.println("Name is : "+name1);
		System.out.println("Message is : "+message);
		model.addAttribute("name", name1);
		model.addAttribute("mess", message);
		return "Display.jsp";
		
	}

}
