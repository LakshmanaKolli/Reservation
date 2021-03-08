package com.epam.hotel.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.response.UpdateReservationResponse;

@RequestMapping("/reservations/api/v1")
public interface ReservationController {

	@PostMapping
	public ResponseEntity<SaveReservationResponse> saveReservationDetails(@RequestBody ReservationDTO reservationDTO)
			throws ReservationException;

	@GetMapping("/{reservationId}")
	public ResponseEntity<ReservationDTO> getReservationDetails(@PathVariable Integer reservationId)
			throws ReservationNotFoundException;

	@PutMapping("/details/{reservationId}")
	public ResponseEntity<UpdateReservationResponse> updateReservationDetails(
			@RequestBody ReservationDTO reservationDTO, @PathVariable Integer reservationId) throws ReservationNotFoundException;

}
