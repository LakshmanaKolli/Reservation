package com.epam.hotel.reservation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer reservation_id;
	
	private Integer guest_id;
	
	private Integer hotel_id;
	
	private String reservation_date;
	
	private String check_in_date;
	
	private String check_out_date;
	
	private Integer total_people;

}
