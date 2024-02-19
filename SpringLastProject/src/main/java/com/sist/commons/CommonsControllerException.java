package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.*;
import java.io.*;

@ControllerAdvice
public class CommonsControllerException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex) {
		System.out.println("============= RuntimeException 발생 ===============");
		ex.printStackTrace();
		System.out.println("==================================================");
	}
	
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex) {
		System.out.println("============= IOException 발생 ===============");
		ex.printStackTrace();
		System.out.println("==================================================");
	}
	
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex) {
		System.out.println("============= SQLException 발생 ===============");
		ex.printStackTrace();
		System.out.println("==================================================");
	}
}
