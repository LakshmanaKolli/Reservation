package com.epam.hotel.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
	
	private Integer guest_id;
	
	private Integer hotel_id;
	
	private String reservation_date;
	
	private String check_in_date;
	
	private String check_out_date;
	
	private Integer total_people;
	
}
