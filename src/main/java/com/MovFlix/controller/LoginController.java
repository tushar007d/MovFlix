package com.MovFlix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getLoginPage() {
		return "Login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String authenticateAdmin(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("password", password);
		model.put("name", name);
		String nam = "Tushar";
		String pass = "123";
		if(name.contentEquals(nam) && password.contentEquals(pass)) {
			return "Admin";
		}
		return "loginerror"; 
	}
	
}
