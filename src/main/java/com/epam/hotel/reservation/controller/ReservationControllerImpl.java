package com.epam.hotel.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.service.ReservationService;

@RestController
public class ReservationControllerImpl implements ReservationController{
	
	@Autowired
	private ReservationService service;
	
	@Override
	public ResponseEntity<SaveReservationResponse> saveReservationDetails(ReservationDTO reservationDTO) throws ReservationException {
		return new ResponseEntity<>(service.saveReservationDetails(reservationDTO), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ReservationDTO> getReservationDetails(Integer reservationId) throws ReservationNotFoundException{
		return new ResponseEntity<>(service.getReservationDetails(reservationId), HttpStatus.OK);
	}

}
