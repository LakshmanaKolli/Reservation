package com.epam.hotel.reservation.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
	
	private Integer hotel_Id;
	
	private String name;
	
	private String description;
	
	private String rating;
	
	private List<RoomDTO> room;
	
	private String phoneNumber;

	private AddressDTO address;

}
