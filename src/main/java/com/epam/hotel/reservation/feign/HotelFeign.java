package com.epam.hotel.reservation.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.reservation.dto.HotelDTO;

@FeignClient(name = "HotelMS")
public interface HotelFeign {

	@RequestMapping(value = "/hotels/api/v1/hotelDetails/{hotelId}")
	HotelDTO getHotelDetails(@PathVariable("hotelId") Integer hotelId);
	
}
