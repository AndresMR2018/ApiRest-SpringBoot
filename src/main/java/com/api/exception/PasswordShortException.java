package com.api.exception;

import org.springframework.stereotype.Component;

@Component
public class PasswordShortException extends Base {

	public PasswordShortException(String errorCode, String errorMesssage) {
		super(errorCode,errorMesssage);
	}
	public PasswordShortException() {
	}
	
}
