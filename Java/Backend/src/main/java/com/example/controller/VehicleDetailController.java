package com.example.controller;

import com.example.entity.Vehicle_detail;
import com.example.service.Vehicle_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-details")
public class VehicleDetailController {

    @Autowired
    private Vehicle_detailService vehicleDetailService;
    
    
    @GetMapping("/component/{id}")
    public ResponseEntity<List<Vehicle_detail>> getVehicleDetailsByComponentId(@PathVariable int id) {
        List<Vehicle_detail> details = vehicleDetailService.findVehicle_detailByComponentId(id);

        if (details.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(details);
    }

    
    @GetMapping("/model/{id}")
    public ResponseEntity<List<Vehicle_detail>> getVehicleDetailsByModelId(@PathVariable int id) {
        List<Vehicle_detail> details = vehicleDetailService.findVehicle_detailByModelId(id);

        if (details.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(details);
    }


    @GetMapping("/all")
    public List<Vehicle_detail> getAllVehicleDetails() {
        return vehicleDetailService.getAllVehicleDetails();
    }

    @PostMapping("/save")
    public Vehicle_detail saveVehicleDetail(@RequestBody Vehicle_detail vehicleDetail) {
        return vehicleDetailService.saveVehicleDetail(vehicleDetail);
    }
    
    @GetMapping("/get/{id}")
    public Vehicle_detail getVehicleDetailById(@PathVariable int id) {
        return vehicleDetailService.getVehicleDetailById(id);
    }

}
