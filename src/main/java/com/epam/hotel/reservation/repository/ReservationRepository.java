package com.epam.hotel.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hotel.reservation.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
