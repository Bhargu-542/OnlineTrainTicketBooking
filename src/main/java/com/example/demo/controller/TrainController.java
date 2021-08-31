package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Train;
import com.example.demo.exception.TrainNotExistedException;
import com.example.demo.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainService;

	@GetMapping("/trains")
	public List<Train> searchByPlace(@RequestParam String fromDestination, @RequestParam String toDestination,
			@RequestParam String date) throws TrainNotExistedException {
		return trainService.searchByPlace(fromDestination,toDestination,date);

	}

}
