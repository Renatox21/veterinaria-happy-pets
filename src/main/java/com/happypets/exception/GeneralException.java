package com.happypets.exception;

public class GeneralException extends Exception {

	public GeneralException(String message) {
		super(message);
	}
	
	public GeneralException(String message, Throwable cause) {
		super(message, cause);		
	}
	
	public GeneralException(Throwable cause) {
		super(cause);
	}

}
