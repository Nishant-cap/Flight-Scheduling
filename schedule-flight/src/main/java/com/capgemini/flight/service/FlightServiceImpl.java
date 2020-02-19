package com.capgemini.flight.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.capgemini.flight.dao.FlightDao;
import com.capgemini.flight.dao.FlightDaoImpl;
import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;
import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;

/*********************************************************************************************************
 * 																										 *                                                                                                    
 * @author Nishant Shrivastav                                                                            * 
 * @Description this class is implementation of Flight service which interact with Client and and        *
 *              validate the user input data and then send it to dao class                               *
 *                                                                                                       *
 *                                                                                                       *
 **********************************************************************************************************/
public class FlightServiceImpl implements FlightService {

	FlightDao dao = new FlightDaoImpl();
	
	/**********************************************************************************************************
	 * @Description:this method interact with Client and validate the Client input and then fetch the data 
	 *              Dao layer 
	 * @method addFlight
	 * @param  flightNum
	 * @param  flightName
	 * @param  seat
	 * @return boolean
	 * @throws IDException
	 * @throws InvalidFlightNameException
	 * @throws SeatException
	 **********************************************************************************************************/
	@Override
	public boolean addFlight(Integer flightNum, String flightName, int seat)
			throws IDException, InvalidFlightNameException, SeatException {

		if (flightNum < 1000 || flightNum > 1100 || (!flightNum.toString().matches("^[1-9]{4}")))
			throw new IDException("Flight ID must contain 4 digit number and connot starts with zero");

		if ((flightName == null) || (flightName.isEmpty()))
			throw new InvalidFlightNameException("Flight must have some name");

		if (seat < 100 || seat > 700)
			throw new SeatException("Flight should have atleast 100 seats and maximun 700");

		Flight flight = new Flight(flightNum, flightName, seat);
		dao.addFlight(flight);

		return true;
	}

	/*********************************************************************************************************
	 * @Description this method will Schedule a Flight with all it data it will fetch data of each airport 
	 *              from flight repository 
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
	@Override
	public boolean addScheduled(Integer Id, Integer flightId, Integer seat, String src, String dest, LocalDateTime arr,
			long noofhours) throws IDException, SeatException, InvalidAirportException, ValidateException {

		if ( (!Id.toString().matches("^[1-9]{4}")) || Id < 2000 || Id > 2100)
			throw new IDException("Scheduled Id must contain 4 digit and cannot start with zero");
		if (seat < 0 || seat > 700 || seat.toString().matches("[1-9]{4}"))
			throw new SeatException("Seat cannot be less than zero and greater than 700");
		Flight flight = dao.viewFlight(flightId);
		Airport srcAirport = dao.getAirport(src);
		Airport destAirport = dao.getAirport(dest);

		if (srcAirport.getAirportName().equalsIgnoreCase(destAirport.getAirportName())
				|| (srcAirport.getAirportName() == null) && destAirport.getAirportName() == null)
			throw new InvalidAirportException("Source and destination cannot be same");
		

		if (arr.isBefore(LocalDateTime.now()))
			throw new ValidateException("Date cannot Lesser than current Date");

		Schedule sch = new Schedule(srcAirport, destAirport, arr, arr.plusHours(noofhours));
		ScheduledFlight schFlight = new ScheduledFlight(Id, flight, seat, sch);
		dao.addScheduled(schFlight);
		return true;
	}

}
