package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidFlightNameException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.service.FlightService;
import com.capgemini.flight.service.FlightServiceImpl;

/****************************************************************************************************************
 * 
 * @author : Nishant Shrivastav
 * @Description :Test case for adding flight
 * @methods : testaddflight1, testaddflight2, testaddflight3, testaddflight4
 *
 ****************************************************************************************************************/
@TestInstance(Lifecycle.PER_CLASS)
public class TestAddFlight {

	private static FlightService ser = new FlightServiceImpl();;

	
	/*********************Test case for validate flight ID***********************************************/
	@Test
	@DisplayName("Test validate for wrong Flight id")
	public void testAddFlight1() throws IDException {
		assertAll("Add Flight", () -> assertThrows(IDException.class, () -> {
			ser.addFlight(12345, "Air India", 700);
		}), () -> assertThrows(IDException.class, () -> {
			ser.addFlight(1005, "Indigo", 400);
		}));

	}

	/*********************Test case for validate Limited Seats into particular flight ********************/
	@Test
	@DisplayName("Test validate for limited seats of flight")
	public void testAddFlight2() {
		assertThrows(SeatException.class, () -> {
			ser.addFlight(1007, "Air India", 900);
		});
	}

	/*********************Test case for validate flight Name**********************************************/
	@Test
	@DisplayName("Test validiate for wrong flight name")
	public void testAddFlight3() {

		assertThrows(InvalidFlightNameException.class, () -> {
			ser.addFlight(1006, "", 300);
		});
	}
	
	
	/*********************Test case for validate flight instance*******************************************/
	@Test
	@DisplayName("Test validate for successfully adding flight instance")
	public void testAddFlight4() throws IDException, InvalidFlightNameException, SeatException {

		assertTrue(ser.addFlight(1006, "Air India", 300));

	}

}
