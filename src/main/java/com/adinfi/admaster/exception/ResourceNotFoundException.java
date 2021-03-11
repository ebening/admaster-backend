package com.adinfi.admaster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(){
		
	}
	
	public ResourceNotFoundException(String msg){
		super(msg);
	}
	
	public ResourceNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}

}
