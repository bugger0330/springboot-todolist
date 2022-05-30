package com.springboot.todolist.web.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.annotation.aop.Validation;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.auth.UsernameCheckDto;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

	@Validation
	@GetMapping("/auth/username")
	public ResponseEntity<?> checkUsername(@Valid @RequestBody UsernameCheckDto usernameCheckDto, BindingResult bindingResult){
		System.out.println(usernameCheckDto);
		
		
		return new ResponseEntity<>(new CMRespDto<Boolean>(1, "username ok", true), HttpStatus.OK);
	}
}
