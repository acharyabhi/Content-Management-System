package com.example.cms.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.Entity.User;
import com.example.cms.Exception.UserAlreadyExistByEmailException;
import com.example.cms.Repository.UserRepository;
import com.example.cms.Service.UserService;
import com.example.cms.Utility.ResponseStructure;
import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	private ResponseStructure<UserResponse> structure;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest) {

		if (userRepository.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistByEmailException("Failed to Register User");

		User saveUser = userRepository.save(mapToUser(new User(), userRequest));

		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User Registered Successfully").setBody(mapToResponse(saveUser)));
	}

	private UserResponse mapToResponse(User saveUser) {
		return UserResponse.builder().userId(saveUser.getUserId())
				.userName(saveUser.getUserName())
				.email(saveUser.getEmail())
				.build();
	}

	private User mapToUser(User user, UserRequest userRequest) {
		
		String encode = passwordEncoder.encode(userRequest.getPassword());
		
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(encode);
		return user;
	}

}
