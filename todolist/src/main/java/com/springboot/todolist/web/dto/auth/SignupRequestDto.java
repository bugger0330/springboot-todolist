package com.springboot.todolist.web.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.todolist.domain.todolist.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class SignupRequestDto {

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.name(name)
				.email(email)
				.build();
	}
	
}
