package com.epam.hotel.reservation.service;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.response.UpdateReservationResponse;

public interface ReservationService {

	SaveReservationResponse saveReservationDetails(ReservationDTO reservationDTO) throws ReservationException;

	ReservationDTO getReservationDetails(Integer reservationID) throws ReservationNotFoundException;

	UpdateReservationResponse updateReservationDetails(ReservationDTO reservationDetails, Integer reservationID) throws ReservationNotFoundException;

}
