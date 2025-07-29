package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Model;
import com.example.service.ModelService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/models")
public class ModelController {
	private final ModelService service;
	
	@Autowired
	public ModelController(ModelService serv) {
		service = serv;
	}
	
	@GetMapping("/mfg_id")
	public ResponseEntity<List<Model>> getModelByMfgId(@PathVariable("mfg_id") int id){
		List<Model> model = service.findModelByManufacturerId(id);
		return ResponseEntity.ok(model);
	}
	
	@GetMapping("/seg_id")
	public ResponseEntity<List<Model>> getModelBySegmentId(@PathVariable("seg_id") int id){
		List<Model> model = service.findModelBySegmentId(id);
		return ResponseEntity.ok(model);
	}
}
