package com.capgemini.flight.dao;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;

/****************************************************************************************************
 * 																									*
 * @author Nishant Shrivastav																		*
 *																									*
 ****************************************************************************************************/
public interface FlightDao {
	
	/**********************************************************************************************************
	 *                                                                                               
	 * @Description: this is interface of data accessing object class for addflight   							 
	 * @Method : addFlight         								 
	 * @param   : flight 								 	 
	 * @return : Flight                                                       
	 * @throws : IDException           										
	 *                                                                                               
	 **********************************************************************************************************/

	public Flight addFlight(Flight flight) throws IDException;
	/**********************************************************************************************************
	 * @Method viewFlight
	 * @param flightId
	 * @return Flight
	 * @throws IDException
	 */
	
	public Flight viewFlight(Integer flightId) throws IDException;
	
	/**********************************************************************************************************
	 * @Mehtod addSchedule
	 * @param schflight
	 * @return boolean
	 * @throws IDException
	 **********************************************************************************************************/

	public boolean addScheduled(ScheduledFlight schflight) throws IDException;
	
	/**********************************************************************************************************
	 * @Mehtod getAirport
	 * @param airport
	 * @return Airport
	 * @throws InvalidAirportException
	 **********************************************************************************************************/

	public Airport getAirport(String airport) throws InvalidAirportException;
	

}
