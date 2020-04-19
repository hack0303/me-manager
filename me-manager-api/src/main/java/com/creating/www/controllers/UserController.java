package com.creating.www.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creating.www.ReqLog;
import com.creating.www.entity.User;

@RestController
@RequestMapping("/")
public class UserController {

	@ReqLog
	@GetMapping("login")
	public User login() {
		User newUser=new User();
		return newUser;
	}
}
