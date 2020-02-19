package com.capgemini.flight.dao;

import java.util.Map;


import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.util.FlightRepository;

/**************************************************************************************************************
 * @Author Name : Nishant Shrivastav                                                                          *
 * @Description: This class is implementation of Flight interface								              *
 * @Methods : addFlight, viewFlight, addScheduled, getAirport                                                 *        								 
 *      										 												              *
 *                                                                                                            *
 **************************************************************************************************************/

public class FlightDaoImpl implements FlightDao {
	

	
/***************************************************************************************************************
 * getting flightMap airportMap scheduleMap scheduledMap from repository
 *
 **************************************************************************************************************/
	public static Map<String, Schedule> schedulemap = FlightRepository.getSchedule();
	public static Map<Integer, ScheduledFlight> scheduledmap = FlightRepository.getSchedulefFlight();
	public static Map<Integer, Flight> flightmap = FlightRepository.getFlightmap();
	public static Map<String, Airport> airportmap = FlightRepository.getAirportmap();

	Flight flight = new Flight();
	
	
	/************************************************************************************************************
	* @Description : this method take a flight instance and check the particular instance in flightMap if it    *
	* 				 is not available in flightMap then it will add the flight otherwise throw exception        *																											*
	* 																											*
	* @Method :      addFlight()                                                                                *
	* @exception:    IDException                                                                                *																										*
	* @return :      Flight                                                                                     *
	* @throws :      IDException																				*
	* @param  :      flight																						*
	*************************************************************************************************************/
		
	@Override
	public Flight addFlight(Flight flight) throws IDException {
		
		if (flightmap.containsKey(flight.getFlightNumber()))
			throw new IDException("Flight Already Exists");

		flightmap.put(flight.getFlightNumber(), flight);
		return flight;
	}

	/************************************************************************************************************
	* @Description : this method will show the flight which is added into repository if ID does not exists then *
	* 				 throw Exception other wise return flight from repository for particular flight ID      	*
	* @Method :      viewFlight()                                                                               *
	* @exception:    IDException                                                                                *																										
	* @return :      Flight                                                                                     *
	* @param  :      flightId                                                                                   *
	* 																											*
	*************************************************************************************************************/
	@Override
	public Flight viewFlight(Integer flightId) throws IDException {
		if (!flightmap.containsKey(flightId))
			throw new IDException("Flight Not Found");
		return flightmap.get(flightId);

	}

	/************************************************************************************************************
	* @Description : this method will add a schedule of a flight into repository if ID  exists then it throw    *
	* 				 Exception other wise add a schedule of flight from repository for particular flight ID     *
	* @Method :      addScheduled()                                                                             *
	* @exception:    IDException                                                                                *																										
	* @return :      boolean                                                                                    *
	* @param  :      ScheduledFlight                                                                            *
	* 																											*
	*************************************************************************************************************/
	@Override
	public boolean addScheduled(ScheduledFlight schflight) throws IDException {
		if (scheduledmap.containsKey(schflight.getScheduledFlightId()))
			throw new IDException("Scheduled ID Already Exists");

		scheduledmap.put(schflight.getScheduledFlightId(), schflight);
		return true;
	}

	/************************************************************************************************************
	* @Description : this method will return airport repository according to it's airport name and if airport   *
	* 				 name is not in repository then it throw Exception                                          *
	* @Method :      addScheduled()                                                                             *
	* @exception:    InvalidAirportException                                                                    *																										
	* @return :      Airport                                                                                    *
	* @param  :      airport                                                                                    *
	* 																											*
	*************************************************************************************************************/
	@Override
	public Airport getAirport(String airport) throws InvalidAirportException {

		if (!airportmap.containsKey(airport))
			throw new InvalidAirportException("No Such Airport Found!");

		return airportmap.get(airport);
	}

}
