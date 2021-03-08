package com.epam.hotel.reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hotel.reservation.domain.Reservation;
import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.mapper.ReservationMapper;
import com.epam.hotel.reservation.repository.ReservationRepository;
import com.epam.hotel.reservation.response.SaveReservationResponse;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	ReservationMapper mapper;

	@Override
	public SaveReservationResponse saveReservationDetails(ReservationDTO reservationDTO) throws ReservationException {
		SaveReservationResponse response = new SaveReservationResponse();
		try {
			reservationRepository.save(mapper.toReservation(reservationDTO));
			response.setMessage("Reservation details saved successfully");
		} catch (Exception e) {
			throw new ReservationException(e.getMessage());
		}
		return response;
	}

	@Override
	public ReservationDTO getReservationDetails(Integer reservationID) throws ReservationNotFoundException {
		Optional<Reservation> response = reservationRepository.findById(reservationID);
		if (response.isEmpty()) {
			throw new ReservationNotFoundException(
					String.format("Reservation details not found for reservationId: %s", reservationID));
		}
		return mapper.toReservationDTO(response.get());
	}

}
