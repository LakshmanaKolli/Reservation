package com.epam.hotel.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.response.SaveReservationResponse;

@RequestMapping("/reservations/api/v1")
public interface ReservationController {
	
	@PostMapping
	public ResponseEntity<SaveReservationResponse> saveReservationDetails(@RequestBody ReservationDTO reservationDTO) throws ReservationException;
	
	@GetMapping("/{reservationId}")
	public ResponseEntity<ReservationDTO> getReservationDetails(Integer reservationId) throws ReservationNotFoundException;

}
