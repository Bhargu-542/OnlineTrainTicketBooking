package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Train;

public  interface TrainRepository extends JpaRepository<Train, Long> {

	@Query(value = "select * from train where from_destination=?1 AND to_destination=?2 And date=?3",nativeQuery=true)
	List<Train> findByFromDestinationAndToDestinationAndDate(String fromDestination, String toDestination, String date);

	Train findByTrainId(long trainId);

	 

	 

}
