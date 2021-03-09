package com.epam.hotel.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private Integer id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String area;
	
	private String pincode;
}
