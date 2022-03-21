package com.api.exception;

public class Base extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMesssage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMesssage() {
		return errorMesssage;
	}
	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Base(String errorCode, String errorMesssage) {
		super();
		this.errorCode = errorCode;
		this.errorMesssage = errorMesssage;
	}
	public Base() {
	
	}
}
