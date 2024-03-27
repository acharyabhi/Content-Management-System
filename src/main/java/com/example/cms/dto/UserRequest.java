package com.example.cms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

//	@NotNull(message = "Fill the username")
//	private String userName;
//
//	@Pattern(regexp = "[a-zA-Z0-9]+[a-z0-9.%\\-\\+]*@(?:[a-zA-Z0-9]+\\.)+[a-zA-z]{2,4}", message = "invalid email")
//
//	private String email;
//	@Pattern(regexp = "^(?=.*[0-9]) (?=.*[a-z]) (?=.*[A-Z]) (?=.*[@#$%^&+=]) (?=\\$+$).{8,}$", message = "Password must "
//			+ "Contain at least one letter, one number, one special character")
//	private String password;

	@NotNull(message = "Fill the UserName")
	private String userName;

	@Pattern(regexp = "[a-zA-Z0-9]+[a-z0-9.%\\-\\+]*@(?:[a-zA-Z0-9]+\\.)+[a-zA-z]{2,4}", message = "invalid email")

	private String email;
	@Pattern(regexp = "^(?=.*[0-9]) (?=.*[a-z]) (?=.*[A-Z]) (?=.*[@#$%^&+=]) (?=\\$+$).{8,}$", message = "Password must "
			+ "Contain at least one letter, one number, one special character")

	private String password;

}
