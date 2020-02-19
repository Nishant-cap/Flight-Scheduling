package com.capgemini.flight.exceptions;

/**************************************************************************************************************
 * 
 * @author Nishant Shrivastav
 * @Description Exception class for validate Schedule
 **************************************************************************************************************/
public class ValidateException extends Exception {

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ValidateException(String message) {
		super(message);
		
	}

}
