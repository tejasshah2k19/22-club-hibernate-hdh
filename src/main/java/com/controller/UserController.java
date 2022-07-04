package com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
		return repository.findAll();//all user --> role = 1 
		//native query  
	}
	@GetMapping("/GetUsersbyrole")
	public List<UserBean> getAllUsersByRole(@RequestParam("roleId") int roleId){
		return repository.findByRole(roleId); //all user --> role = 1 
		//native query  
	}
	
	
	
	@DeleteMapping("/deleteuser")
	public List<UserBean> deleteUser(@RequestParam("userId") UUID userId){
		repository.deleteById(userId);
		return repository.findAll();
	}
	
	@PutMapping("/updateuser")
	public List<UserBean> updateUser(@RequestBody  UserBean user){
		repository.save(user);//already pk ? present ? yes update else insert 
		return repository.findAll();
	}
	
	 //login api 
	//email password 

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserBean bean) {
	 
		UserBean user = repository.findByUserNameAndPassword(bean.getUserName(),bean.getPassword());
		if(user == null)
			return  new ResponseEntity("Invalid Credentials", HttpStatus.BAD_REQUEST);
		else
			return ResponseEntity.ok(user);

		
	}
	
	

}
