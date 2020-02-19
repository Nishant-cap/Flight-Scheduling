package com.capgemini.flight.entity;

/*************************************************************************************************************
 * 
 * 
 * @author Nishant Shrivastav
 * @Description this is entity class for Flight class
 **************************************************************************************************************/

public class Flight {

	/**********************************************************************************************************
	 * Initializing variables
	 **********************************************************************************************************/
	private Integer flightNumber;
	private String flightName;
	private Integer seatCapacity;

	/**********************************************************************************************************
	 * @Mehtod default constructor
	 **********************************************************************************************************/
	public Flight() {

	}

	/**********************************************************************************************************
	 * @Method Flight constructor of Flight class
	 * @param flightNumber
	 * @param flightName
	 * @param seatCapacity
	 **********************************************************************************************************/
	public Flight(Integer flightNumber, String flightName, Integer seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.seatCapacity = seatCapacity;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {

		return "\nFlight Number: " + flightNumber + "\nFlight Name: " + flightName + "\nSeat Capacity: " + seatCapacity
				+ "";
	}

}
