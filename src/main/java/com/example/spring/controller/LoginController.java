package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.model.PersonModel;
import com.example.spring.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;

	@Autowired(required = true)
	@Qualifier(value = "loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String RedirectPage(Model model) {
		model.addAttribute("person", new PersonModel());
		return "person";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "login";
	}
	
	@RequestMapping(value = "/loginvalidation", method = RequestMethod.POST)
	public String loginValidation(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, Model model) {
		System.out.println(username + " " + password);
		
		String errorMessge = null;
		if (username == "" || password == "") {
			errorMessge = "Please enter required fields !!";
			model.addAttribute("errorMessge", errorMessge);
		} else {
			if(this.loginService.validateuser(username, password)) {
				model.addAttribute("person", new PersonModel());
				return "person";
			} else {
				errorMessge = "Username or Password is incorrect !!";
				model.addAttribute("errorMessge", errorMessge);
			}
		}
		
		//model.addAttribute("person", new PersonModel());
		return "login";
	}
}
