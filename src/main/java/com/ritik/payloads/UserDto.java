package com.ritik.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long userId;

	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String lastname;
	
	
	@NotEmpty
	@Email
	private String email;

	private String phoneNumber;

	private Integer animalId;
}
