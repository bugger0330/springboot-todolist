package com.springboot.todolist.domain.todolist;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private int usercode;
	private String username;
	private String password;
	private String name;
	private String email;
	private LocalDateTime create_date;
	private LocalDateTime update_date;

}
