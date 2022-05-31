package com.springboot.todolist.web.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.annotation.aop.Validation;
import com.springboot.todolist.service.AuthService;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.auth.SignupRequestDto;
import com.springboot.todolist.web.dto.auth.UsernameCheckDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	@Validation
	@GetMapping("/signup/username")
	public ResponseEntity<?> checkUsername(@Valid UsernameCheckDto usernameCheckDto, BindingResult bindingResult) throws Exception {
		System.out.println(usernameCheckDto);
		
		
		return new ResponseEntity<>(new CMRespDto<Boolean>(1, "username ok", authService.checkUsername(usernameCheckDto.getUsername())), HttpStatus.OK);
	}
	

	@Validation
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestDto signupRequestDto, BindingResult bindingResult) throws Exception {
		System.out.println("회원가입 : " + signupRequestDto.toString());

		return new ResponseEntity<>(new CMRespDto<Boolean>(1, "username ok", authService.signup(signupRequestDto)), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
