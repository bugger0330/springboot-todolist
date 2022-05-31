package com.springboot.todolist.config.auth;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.todolist.User;
import com.springboot.todolist.domain.todolist.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userEntity = null;
		try {
			userEntity = userRepository.findUserByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userEntity);
		System.out.println("로그인 요청?");
		
		
		
		return new PrincipalDetails(userEntity);
	}

}
