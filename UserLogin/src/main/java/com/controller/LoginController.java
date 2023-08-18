package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	ILoginDao loginDao;
	
	@GetMapping("/login")
	public String getLoginpage() {
		return "login";
	}
	
	@PostMapping("/dologin")
	public String checkUser(@RequestParam String username,@RequestParam String password) {
		boolean loginFlag=loginDao.validateUser(username, password);
		if(loginFlag==true) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
