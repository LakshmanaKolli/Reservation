package com.epam.hotel.reservation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.hotel.reservation.dto.HotelDTO;
import com.epam.hotel.reservation.feign.HotelFeign;

@SpringBootTest(properties = "hotel.service.name=Hotel")
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"Hotel:Hotel:+:stubs:6565"},stubsMode = StubsMode.LOCAL)
public class IntegrationTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	HotelFeign hotelFeign;
	
	@WithMockUser(username = "username",password = "password")
	@Test
	void getHotelDetailsContractTest() throws Exception {
		this.mockMvc.perform(get("/reservations/api/v1/1")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.guest_id", is(0)));
	}
}
