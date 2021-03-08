package com.epam.hotel.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.epam.hotel.reservation.response.ErrorResponse;

@RestControllerAdvice
public class ReservationExceptionHandler {
	
	@ExceptionHandler(ReservationException.class)
	public final ResponseEntity<Object> reservationException(ReservationException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 500);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(ReservationNotFoundException.class)
	public final ResponseEntity<Object> reservationNotFoundException(ReservationNotFoundException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 404);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);	
	}

}
