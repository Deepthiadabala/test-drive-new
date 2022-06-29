package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.BikeModel;
import com.stg.model.Booking;
import com.stg.repository.BookingRepo;
@RestController
@RequestMapping(value = "booking")
public class BookingController {
	@Autowired
	private BookingRepo bookingRepo;
	@GetMapping("/get")
	public ResponseEntity<List<Booking>> readBikeByName() {
		List<Booking> bookings=bookingRepo.findAll();
		
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.CREATED);
	}
	

}
