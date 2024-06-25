package com.ritik.services;

import com.ritik.vo.ResponseTemplateVO;
import org.springframework.stereotype.Service;

import com.ritik.payloads.UserDto;

public interface UserService {
	
	public UserDto registerUser(UserDto userDto);

	public ResponseTemplateVO getUserWithAnimal(Long userId);

}
