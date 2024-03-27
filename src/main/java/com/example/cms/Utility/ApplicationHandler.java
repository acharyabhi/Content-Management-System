package com.example.cms.Utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.cms.Exception.UserAlreadyExistByEmailException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ApplicationHandler {

	private ErrorStructure<String> errorStructure;
	
	public ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus code, String message, String rootCause)
	{
		return ResponseEntity.ok(errorStructure.setErrorStatusCode(code.value()).setErrorMessage(message).setRootCause(rootCause));
	}
	
	public ResponseEntity<ErrorStructure<String>> handleUserAlreadyExistByEmail(UserAlreadyExistByEmailException e)
	{
		return errorResponse(HttpStatus.BAD_REQUEST, e.getMessage(), "User is already exist in email");
	}
}
