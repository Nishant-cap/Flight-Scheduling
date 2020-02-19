package com.capgemini.flight.exceptions;

/**************************************************************************************************************
 * 
 * @author Nishant Shrivastav
 * @Description Exception class for Invalid Input of Arrival time
 **************************************************************************************************************/
public class WrongInputFormatException extends Exception {

	public WrongInputFormatException() {
		super();
		
	}

	public WrongInputFormatException(String message) {
		super(message);
		
	}
	
	

}
