package com.manish.DTO;

import lombok.Data;

@Data
public class UserResponseDTO {

	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private Long contactId;

	private String role;

	private String city;
	private String state;
	private String country;
	private String pincode;

	private Boolean active;

	private String gender;
	private Integer age;
}
