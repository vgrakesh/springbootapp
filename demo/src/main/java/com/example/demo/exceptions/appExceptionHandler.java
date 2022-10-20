package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.ui.responseModels.ErrorResponse;

@ControllerAdvice
public class appExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse();
		err.setTimestamp(new Date());
		err.setErrorMessage(ex.getMessage() + " : " + ex.getLocalizedMessage());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerExceptions(NullPointerException ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse();
		err.setTimestamp(new Date());
		err.setErrorMessage("NP : " + ex.getMessage() + " : " + ex.getLocalizedMessage());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {AppBusinessException.class})
	public ResponseEntity<Object> handleBusinessExceptions(AppBusinessException ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse();
		err.setTimestamp(new Date());
		err.setErrorMessage("BE : " + ex.getMessage() + " : " + ex.getLocalizedMessage());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
