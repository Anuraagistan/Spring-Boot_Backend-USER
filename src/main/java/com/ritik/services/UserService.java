package com.ritik.services;

import org.springframework.stereotype.Service;

import com.ritik.payloads.UserDto;

public interface UserService {
	
	public UserDto registerUser(UserDto userDto);

}
