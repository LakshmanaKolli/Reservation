package com.epam.hotel.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.response.UpdateReservationResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/reservations/api/v1")
public interface ReservationController {

	@Operation(summary = "Saves reservation details")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Saved reservation details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SaveReservationResponse.class)) }) })
	@PostMapping
	public ResponseEntity<SaveReservationResponse> saveReservationDetails(@RequestBody ReservationDTO reservationDTO)
			throws ReservationException;

	@Operation(summary = "Fetches reservation details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetched reservation details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ReservationDTO.class)) }) })
	@GetMapping("/{reservationId}")
	public ResponseEntity<ReservationDTO> getReservationDetails(@PathVariable Integer reservationId)
			throws ReservationNotFoundException;

	@Operation(summary = "Updates reservation details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated reservation details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UpdateReservationResponse.class)) }) })
	@PutMapping("/details/{reservationId}")
	public ResponseEntity<UpdateReservationResponse> updateReservationDetails(
			@RequestBody ReservationDTO reservationDTO, @PathVariable Integer reservationId) throws ReservationNotFoundException;

}
