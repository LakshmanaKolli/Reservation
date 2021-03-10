package com.epam.hotel.reservation.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hotel.reservation.domain.Reservation;
import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.exception.ReservationException;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.feign.HotelFeign;
import com.epam.hotel.reservation.mapper.ReservationMapper;
import com.epam.hotel.reservation.repository.ReservationRepository;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.response.UpdateReservationResponse;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	ReservationMapper mapper;
	
	@Autowired
	HotelFeign hotelFeign;

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
		System.out.println(hotelFeign.getHotelDetails(2).toString());
		Optional<Reservation> response = reservationRepository.findById(reservationID);
		if (response.isEmpty()) {
			throw new ReservationNotFoundException(
					String.format("Reservation details not found for reservationId: %s", reservationID));
		}
		return mapper.toReservationDTO(response.get());
	}

	@Override
	public UpdateReservationResponse updateReservationDetails(ReservationDTO reservationDetails,
			Integer reservationID) throws ReservationNotFoundException {
		Optional<Reservation> domain = reservationRepository.findById(reservationID);
		if(domain.isEmpty()) {
			throw new ReservationNotFoundException(
					String.format("Reservation details not found for reservationId: %s", reservationID));
		}
		Reservation reserve = domain.get();
		reserve.setCheck_in_date(reservationDetails.getCheck_in_date());
		reserve.setCheck_out_date(reservationDetails.getCheck_out_date());
		reserve.setGuest_id(reservationDetails.getGuest_id());
		reserve.setHotel_id(reservationDetails.getHotel_id());
		reserve.setReservation_date(LocalDate.now().toString());
		reservationRepository.save(reserve);
		return new UpdateReservationResponse("Reservation details updated successfully");
	}

}
