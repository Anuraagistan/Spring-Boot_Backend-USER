package com.ritik.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.User;
import com.ritik.payloads.UserDto;
import com.ritik.repositories.UserRepository;
import com.ritik.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user=this.userDtoToUser(userDto);
		User newUser=this.userRepository.save(user);
		return this.usertoDto(newUser);
		
	}

	
	
	public UserDto usertoDto(User user) {
		
		return this.modelMapper.map(user, UserDto.class);
	}
	
	public User userDtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}
}
