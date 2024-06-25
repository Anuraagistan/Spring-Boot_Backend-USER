package com.ritik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.services.UserService;
import com.ritik.vo.Animal;
import com.ritik.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/user")
public class UserActivityController {

	@Autowired
	UserService userService;
	
	@GetMapping("/animal/{userId}")
	public ResponseEntity<ResponseTemplateVO> getUserWithAnimal(@PathVariable final Long userId){
		ResponseTemplateVO vo = this.userService.getUserWithAnimal(userId);

		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addAnimal")
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal){
		Animal savedAnimal = this.userService.addAnimal(animal);

		return new ResponseEntity<>(savedAnimal, HttpStatus.OK);
	}
}
