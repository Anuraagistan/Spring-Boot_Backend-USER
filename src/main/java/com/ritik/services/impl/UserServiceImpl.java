package com.ritik.services.impl;

import com.ritik.exceptions.ResourceNotFoundException;
import com.ritik.vo.Animal;
import com.ritik.vo.ResponseTemplateVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.entity.User;
import com.ritik.payloads.UserDto;
import com.ritik.repositories.UserRepository;
import com.ritik.services.UserService;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;
	

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user=this.userDtoToUser(userDto);
		User newUser=this.userRepository.save(user);
		return this.usertoDto(newUser);
		
	}

	@Override
	public ResponseTemplateVO getUserWithAnimal(Long userId){
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findById(userId).orElseThrow(() -> {
			return new ResourceNotFoundException("User", "userId", userId);
		});
		Animal animal = restTemplate.getForObject
			("http://localhost:9090/api/animal/" + user.getAnimalId()
			,Animal.class);
		UserDto userDto = this.usertoDto(user);
		vo.setUser(userDto);
		vo.setAnimal(animal);

		return vo;

	}
	
	public Animal addAnimal(Animal animal) {
		Animal savedAnimal=restTemplate.postForObject("http://localhost:9090/api/animal/add", animal, Animal.class);
		return savedAnimal;
	
	}
	
	
	public UserDto usertoDto(User user) {
		
		return this.modelMapper.map(user, UserDto.class);
	}
	
	public User userDtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}
}
