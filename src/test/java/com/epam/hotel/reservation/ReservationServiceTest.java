package com.epam.hotel.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.hotel.reservation.domain.Reservation;
import com.epam.hotel.reservation.exception.ReservationNotFoundException;
import com.epam.hotel.reservation.repository.ReservationRepository;
import com.epam.hotel.reservation.service.ReservationService;

@SpringBootTest
public class ReservationServiceTest extends AbstractBaseTest {

	@MockBean
	ReservationRepository reservationRepository;

	@Autowired
	ReservationService reservationService;

	@Test
	void saveReservationDetails() throws Exception {
		Reservation domain = reservationMapper.toReservation(getReservationDTOdetails());
		Mockito.when(reservationRepository.save(domain)).thenReturn(domain);
		assertEquals("Reservation details saved successfully",
				reservationService.saveReservationDetails(getReservationDTOdetails()).getMessage());
	}

	@Test
	void getReservationDetails() throws Exception {
		Optional<Reservation> response = Optional.of(reservationMapper.toReservation(getReservationDTOdetails()));
		Mockito.when(reservationRepository.findById(1)).thenReturn(response);
		assertEquals(1, reservationService.getReservationDetails(1).getHotel_id());
	}

	@Test
	void getReservationDetails_notFoundException() throws Exception {
		Exception ex = assertThrows(ReservationNotFoundException.class,
				() -> reservationService.getReservationDetails(0));
		assertEquals("Reservation details not found for reservationId: 0", ex.getMessage());
	}
	
	@Test
	void updateReservationDetails() throws Exception{
		Reservation response = reservationMapper.toReservation(getReservationDTOdetails());
		Mockito.when(reservationRepository.findById(1)).thenReturn(Optional.of(response));
		Mockito.when(reservationRepository.save(response)).thenReturn(response);
		assertEquals("Reservation details updated successfully", reservationService.updateReservationDetails(getReservationDTOdetails(), 1).getMessage());
	}
	
	@Test
	void updateReservationDetails_notFoundException() throws Exception {
		Exception ex = assertThrows(ReservationNotFoundException.class,
				() -> reservationService.updateReservationDetails(getReservationDTOdetails(), 0));
		assertEquals("Reservation details not found for reservationId: 0", ex.getMessage());
	}

}
