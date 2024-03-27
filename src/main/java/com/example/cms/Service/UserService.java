package com.example.cms.Service;

import org.springframework.http.ResponseEntity;

import com.example.cms.Utility.ResponseStructure;
import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponse;

import jakarta.validation.Valid;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid UserRequest userRequest);

}
