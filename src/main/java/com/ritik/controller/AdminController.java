package com.ritik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.entity.User;
import com.ritik.payloads.UserDto;
import com.ritik.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class AdminController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/signUp")
	public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto){
		
		UserDto savedUser=userService.registerUser(userDto);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
	}
}
