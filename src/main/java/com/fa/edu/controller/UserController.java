package com.fa.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/generate-password/{value}")
	public ModelAndView generatePassword(@PathVariable("value") String password) {
		ModelAndView view = new ModelAndView("login");
		System.out.println("password encode is : " + bCryptPasswordEncoder.encode(password));
		return view;
	}

}
