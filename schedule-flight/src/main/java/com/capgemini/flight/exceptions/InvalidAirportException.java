package com.capgemini.flight.exceptions;

/**************************************************************************************************************
 * 
 * @author Nishant Shrivastav
 * @Description Exception class for Invalid Airport Name
 **************************************************************************************************************/
public class InvalidAirportException extends Exception {


	public InvalidAirportException(String arg0) {
		super(arg0);
		
	}

	public InvalidAirportException(Throwable cause) {
		super(cause);
		
	}
	

}
