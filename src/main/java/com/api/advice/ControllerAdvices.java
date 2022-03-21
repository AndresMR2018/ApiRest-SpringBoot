package com.api.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.exception.EmptyInputException;
import com.api.exception.NotExistIdException;
import com.api.exception.PasswordShortException;

@ControllerAdvice
public class ControllerAdvices extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException eie){
		return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordShortException.class)
	public ResponseEntity<String> handlePasswordShortException(PasswordShortException pse){
		return new ResponseEntity<String>("Password very short",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotExistIdException.class)
	public ResponseEntity<String> handleNotExistId(NotExistIdException nei){
		return new ResponseEntity<String>("Not exist object with that id",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException nse){
		return new ResponseEntity<String>("No value present in DB",HttpStatus.NOT_FOUND);
	}
	
	/*@ExceptionHandler(Message.class)
	public ResponseEntity<String> handleMessage(Message m){
		return new ResponseEntity<String>("no products yet",HttpStatus.OK);
	}*/
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Invalid http method.",HttpStatus.NOT_FOUND);
	}
}
