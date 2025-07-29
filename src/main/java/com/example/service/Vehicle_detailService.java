package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Vehicle_detail;
import com.example.repository.Vehicle_detailRepository;

@Service
public class Vehicle_detailService {
	@Autowired
	private Vehicle_detailRepository repo;
	
	public List<Vehicle_detail> findVehicle_detailByComponentId(int id) {
		return repo.findVehicle_detailByComponentId(id);
	}
	
	public List<Vehicle_detail> findVehicle_detailByModelId(int id) {
		return repo.findVehicle_detailByModelId(id);
	}
}
