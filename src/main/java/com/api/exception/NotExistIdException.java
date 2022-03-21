package com.api.exception;

public class NotExistIdException extends Base {
	
	public NotExistIdException(String errorCode, String errorMesssage) {
		super(errorCode,errorMesssage);
	}
	public NotExistIdException() {
	
	}
	
}
