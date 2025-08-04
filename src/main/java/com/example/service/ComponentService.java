package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Component;
import com.example.repository.ComponentRepository;

@Service
public class ComponentService {
	@Autowired
	private ComponentRepository repo;
	
	public Optional<Component> findById(int id){
		return repo.findById(id);
	}
	
	public List<Component> findComponentByModelId(int id){
		return repo.findComponentByModelId(id);
	}
	
	public List<Component> getAllComponents() {
        return repo.findAll();
    }

    
    public Component saveComponent(Component component) {
        return repo.save(component);
    }
    
    
    public Component getComponentById(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Component not found with id: " + id));
    }
	 
	    
	
}
