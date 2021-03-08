package com.epam.hotel.reservation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.service.ReservationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ReservationControllerTest extends AbstractBaseTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ReservationService reservationService;

	@Test
	void saveReservationDetails() throws Exception {
		ReservationDTO dto = getReservationDTOdetails();
		Mockito.when(reservationService.saveReservationDetails(dto)).thenReturn(new SaveReservationResponse());
		mockMvc.perform(post("/reservations/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(dto))).andExpect(status().isCreated());
	}

	@Test
	void getReservationDetails() throws Exception{
		Mockito.when(reservationService.getReservationDetails(1)).thenReturn(getReservationDTOdetails());
		mockMvc.perform(get("/reservations/api/v1/1")).andExpect(status().isOk());
	}

}
