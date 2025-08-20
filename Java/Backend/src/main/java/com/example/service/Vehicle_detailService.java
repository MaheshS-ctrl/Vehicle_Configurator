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
<<<<<<< HEAD
=======
	
	public List<Vehicle_detail> getAllVehicleDetails() {
        return repo.findAll();
    }

    public Vehicle_detail saveVehicleDetail(Vehicle_detail vehicleDetail) {
        return repo.save(vehicleDetail);
    }
    
    public Vehicle_detail getVehicleDetailById(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("VehicleDetail not found with id: " + id));
    }
>>>>>>> Vehicle_Conf_Controller
}
