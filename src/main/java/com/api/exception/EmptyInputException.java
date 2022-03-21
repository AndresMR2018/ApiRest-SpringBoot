package com.api.exception;

import org.springframework.stereotype.Component;

@Component
	public class EmptyInputException extends Base {
	
	public EmptyInputException() {
	super();
	}
	
	public EmptyInputException(String errorCode, String errorMesssage) {
		super(errorCode,errorMesssage);
	}
	
}
