package com.springboot.todolist.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.todolist.handler.exeception.CustomValidationApiException;
import com.springboot.todolist.web.dto.CMRespDto;

@RestController
@RestControllerAdvice 
//@RestControllerAdvice 무조건 json으로 리턴한다
public class ControllerExceptionHandler {

	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e){
		return new ResponseEntity<>(new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.OK);
	}
	
}