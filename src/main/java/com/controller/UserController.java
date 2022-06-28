package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody UserBean bean) {
		bean.setRole(0);
		bean.setUserStatus(0);
		System.out.println("in controller");
		System.out.println(bean.getUserName());
		repository.save(bean);

		
	}
	@GetMapping("/GetUsers")
	public List<UserBean> getAllUsers(){
		return repository.findAll();
	}
}
