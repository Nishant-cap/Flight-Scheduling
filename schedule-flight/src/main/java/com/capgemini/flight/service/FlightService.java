package com.capgemini.flight.service;

import java.time.LocalDateTime;

import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;
/*************************************************************************************************************
 * 
 * @author Nishant Shrivastav
 *@description: interface of service 
 *************************************************************************************************************/
public interface FlightService {

	/*********************************************************************************************************
	 * @method addFlight
	 * @param flightNum
	 * @param flightName
	 * @param seat
	 * @return boolean
	 * @throws IDException
	 * @throws InvalidFlightNameException
	 * @throws SeatException
	 **********************************************************************************************************/
	public boolean addFlight(Integer flightNum, String flightName, int seat)
			throws IDException, InvalidFlightNameException, SeatException;
	/*********************************************************************************************************
	 * @method addScheduled
	 * @param Id
	 * @param flightId
	 * @param seat
	 * @param src
	 * @param dest
	 * @param arr
	 * @param noOfhours
	 * @return boolean
	 * @throws IDException
	 * @throws SeatException
	 * @throws InvalidAirportException
	 * @throws ValidateException
	 **********************************************************************************************************/

	public boolean addScheduled(Integer Id, Integer flightId, Integer seat, String src, String dest, LocalDateTime arr,
			long noOfhours) throws IDException, SeatException, InvalidAirportException, ValidateException;

}
