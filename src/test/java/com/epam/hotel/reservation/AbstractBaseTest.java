package com.epam.hotel.reservation;

import java.time.LocalDate;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.mapper.ReservationMapper;
import com.epam.hotel.reservation.mapper.ReservationMapperImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractBaseTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	ReservationMapper reservationMapper = new ReservationMapperImpl();
	
	public ReservationDTO getReservationDTOdetails() {
		ReservationDTO dto = new ReservationDTO(1, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().plusDays(1).toString(), 1);
		return dto;
	}

}
