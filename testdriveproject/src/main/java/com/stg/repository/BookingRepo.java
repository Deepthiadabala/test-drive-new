package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.model.Booking;
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
	@Query(value = "select * from booking")
	public abstract List<Booking> readBookings();

}
