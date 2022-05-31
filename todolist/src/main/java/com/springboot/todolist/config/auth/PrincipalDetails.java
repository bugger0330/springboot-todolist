package com.springboot.todolist.config.auth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.todolist.domain.todolist.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails { 

	private static final long serialVersionUID = 1L;
	private User user;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	

	/* =========================================== */ // 이걸 보고 로그인을 시켜준다
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	
	/* =========================================== *///하나라도 false가 있으면 실행이 안된다

	@Override
	public boolean isAccountNonExpired() { // 계정이 만료되었는지 확인
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 비밀번호가 지정한 횟수 이상 틀리면 잠김
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //자격 증명이 만료가 되면 계정사용 불가
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { // 휴먼계정
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/* =========================================== */


}
