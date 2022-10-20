package com.example.demo.exceptions;

public class AppBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2932787735662325339L;

	public AppBusinessException(String message) {
		super(message);
	}
}
