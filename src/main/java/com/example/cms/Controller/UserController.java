package com.example.cms.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.Service.UserService;
import com.example.cms.Utility.ResponseStructure;
import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {

	private UserService userService;

	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest) {
		System.out.println(userRequest.getUserName());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getPassword());
		return userService.registerUser(userRequest);
	}

	@GetMapping("/test")
	public String test() {
		return "Hello from CMS";
	}
}
