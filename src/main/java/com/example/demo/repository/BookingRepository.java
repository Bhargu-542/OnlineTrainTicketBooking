package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Booking;




public interface BookingRepository extends JpaRepository<Booking,Long> {

	@Query(value = "select * from booking b inner join user u on b.user_id = u.user_id where u.user_id =?1", nativeQuery = true)
    List<Booking> getTicketsbyId(long userId);

}
