package com.springboot.todolist.service;

import com.springboot.todolist.web.dto.auth.SignupRequestDto;

public interface AuthService {

	public boolean checkUsername(String username) throws Exception;
	public boolean signup(SignupRequestDto signupRequestDto) throws Exception; 
}
