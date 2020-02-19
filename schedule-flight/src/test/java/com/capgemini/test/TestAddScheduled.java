package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.exceptions.IDException;
import com.capgemini.flight.exceptions.InvalidAirportException;
import com.capgemini.flight.exceptions.SeatException;
import com.capgemini.flight.exceptions.ValidateException;
import com.capgemini.flight.service.FlightService;
import com.capgemini.flight.service.FlightServiceImpl;

/****************************************************************************************************************
 * 
 * @author : Nishant Shrivastav
 * @Description :Test case for scheduling flight
 * @methods : testaddschedule1test, testaddschedule2test, testaddschedule3test, testaddschedule4test
 *
 ****************************************************************************************************************/
@TestInstance(Lifecycle.PER_CLASS)
public class TestAddScheduled {
	private static FlightService ser=new FlightServiceImpl();

	/*********************Test case for validate scheduled ID***********************************************/
	@Test
	@DisplayName("Test for validate scheduled ID")
	public void testAddSchedule1test() {
		assertThrows(IDException.class, () -> {
			ser.addScheduled(53232, 1005, 120, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2020-05-13").atTime(LocalTime.parse("06:30")), 1);
		});
	}

	/*********************Test case for validate Arrival date ***********************************************/
	@Test
	@DisplayName("Test for validate arrival date")
	public void testAddSchedule2test() {
		assertThrows(ValidateException.class, () -> {
			ser.addScheduled(2006, 1005, 120, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2019-05-05").atTime(LocalTime.parse("06:30")), 1);
		});
	}

	/*********************Test case for validate available seats***********************************************/
	@Test
	@DisplayName("Test for validate available seats")
	public void testAddSchedule3test() {

		assertThrows(SeatException.class, () -> {
			ser.addScheduled(2006, 1005, 1200, "Mysore Airport", "Pune Airport",
					LocalDate.parse("2020-05-03").atTime(LocalTime.parse("07:30")), 1);
		});
	}

	/*********************Test case for validate scheduled a flight***********************************************/
	@Test
	@DisplayName("Test for validate Schduled a flight")
	public void testaddSchedule3test() throws IDException, SeatException, InvalidAirportException, ValidateException {
		LocalDateTime ltd=LocalDate.parse("2020-05-13").atTime(LocalTime.parse("06:30"));
		assertTrue(ser.addScheduled(2007, 1005, 120,"Mysore Airport" ,"Pune Airport", ltd,1l));
	}

}
