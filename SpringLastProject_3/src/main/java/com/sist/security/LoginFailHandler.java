package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Setter;

public class LoginFailHandler implements AuthenticationFailureHandler{
	@Setter
	private String defaultFailerUrl;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String errorMsg="";
		
		try {
			if(exception instanceof BadCredentialsException) {
				errorMsg = "아이디나 비밀번호가 틀립니다.";
			}
			else if(exception instanceof InternalAuthenticationServiceException){
				errorMsg = "아이디나 비밀번호가 틀립니다.";
			}
			else if(exception instanceof DisabledException){
				errorMsg = "휴먼 계정입니다.";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("message", errorMsg);
		//데이터를 담아서 넘기기 때문에 forward 사용
		request.getRequestDispatcher(defaultFailerUrl).forward(request, response);;
		
	}

}
