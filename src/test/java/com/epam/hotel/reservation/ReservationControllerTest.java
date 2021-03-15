package com.epam.hotel.reservation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.hotel.reservation.dto.ReservationDTO;
import com.epam.hotel.reservation.response.SaveReservationResponse;
import com.epam.hotel.reservation.response.UpdateReservationResponse;
import com.epam.hotel.reservation.service.ReservationService;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationControllerTest extends AbstractBaseTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ReservationService reservationService;

	@WithMockUser(username = "username",password = "password")
	@Test
	void saveReservationDetails() throws Exception {
		ReservationDTO dto = getReservationDTOdetails();
		Mockito.when(reservationService.saveReservationDetails(dto)).thenReturn(new SaveReservationResponse());
		mockMvc.perform(post("/reservations/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(dto))).andExpect(status().isCreated());
	}

	@WithMockUser(username = "username",password = "password")
	@Test
	void getReservationDetails() throws Exception {
		Mockito.when(reservationService.getReservationDetails(1)).thenReturn(getReservationDTOdetails());
		mockMvc.perform(get("/reservations/api/v1/1")).andExpect(status().isOk());
	}

	@WithMockUser(username = "username",password = "password")
	@Test
	void updateReservationDetails() throws Exception {
		UpdateReservationResponse response = new UpdateReservationResponse();
		Mockito.when(reservationService.updateReservationDetails(getReservationDTOdetails(),1)).thenReturn(response);
		mockMvc.perform(put("/reservations/api/v1/details/1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(getReservationDTOdetails()))).andExpect(status().isOk());
	}

}
