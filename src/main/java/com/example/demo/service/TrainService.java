package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Train;
import com.example.demo.exception.TrainNotExistedException;

public interface TrainService {

	public List<Train> searchByPlace(String fromDestination, String toDestination, String date) throws TrainNotExistedException;
		 



}
