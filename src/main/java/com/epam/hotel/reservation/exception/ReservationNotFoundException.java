package com.epam.hotel.reservation.exception;

public class ReservationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5804484893009170682L;

	public ReservationNotFoundException(String message) {
		super(message);
	}
}
