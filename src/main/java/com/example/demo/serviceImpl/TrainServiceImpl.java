package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Train;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainRepository trainRepository;

	@Override
	public List<Train> searchByPlace(String fromDestination, String toDestination, String date)
			throws TrainNotExistedException {
		List<Train> train = trainRepository.findByFromDestinationAndToDestinationAndDate(fromDestination, toDestination,
				date);
		if (!train.isEmpty()) {
			return train;
		} else {
			throw new TrainNotExistedException("Trains not existed for selected destinations");
		}
	}

}
