package com.springboot.todolist.service;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.todolist.UserRepository;
import com.springboot.todolist.web.dto.auth.SignupRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;

	@Override
	public boolean checkUsername(String username) throws Exception {
		
		return userRepository.findUserByUsername(username) == null;
	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) throws Exception {

		return userRepository.save(signupRequestDto.toEntity()) > 0;
	}

	

}
