package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Model;
import com.example.repository.ModelRepository;

@Service
public class ModelService {
	@Autowired
	private ModelRepository repo;
	
	public List<Model> findModelByManufacturerId(int id){
		return repo.findModelByManufacturerId(id);
	}
	
	public List<Model> findModelBySegmentId(int id){
		return repo.findModelBySegmentId(id);
	}
	
}
