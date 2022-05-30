package com.springboot.todolist.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.springboot.todolist.handler.exeception.CustomValidationApiException;

@Aspect
@Component
public class ValidationAop {

	@Pointcut("within(com.springboot.todolist.web.controller..*)")
	private void pointcut() {}
	
	@Pointcut("@annotation(com.springboot.todolist.annotation.aop.Validation)")
	private void enableValid() {}
	
	
	//BindingResult 체크 하는것
	@Before("pointcut() && enableValid()")
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();//모든 메소드 안의 매개변수들을 들고온다
		for(Object arg : args) {//매개변수를 하나씩 들고온다(Object 타입으로 들고옴)
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if(bindingResult.hasErrors()) {//에러가 존재하면 맵에 담아라
					Map<String, String> errorMap = new HashMap<String, String>();//<어떤 변수에 ,어떤 오류가 났는지>
					bindingResult.getFieldErrors().forEach(fieldError -> {//getFieldErrors 얘가 리스트 타입이라 foreach를 돌릴수 있다
						errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
					});
					throw new CustomValidationApiException("유효성 검사 실패", errorMap);
				}
			}
		}
		
	}
	
	
	
	
}
