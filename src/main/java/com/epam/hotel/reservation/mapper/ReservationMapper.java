package com.epam.hotel.reservation.mapper;

import org.mapstruct.Mapper;

import com.epam.hotel.reservation.domain.Reservation;
import com.epam.hotel.reservation.dto.ReservationDTO;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
	
	Reservation toReservation(ReservationDTO dto);
	ReservationDTO toReservationDTO(Reservation domain);
	
}
