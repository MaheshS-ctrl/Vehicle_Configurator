package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Alternate_Component_Master;
import com.example.repository.Alternate_Component_MasterRepository;

@Service
public class Alternate_Component_MasterService {
	@Autowired
	private Alternate_Component_MasterRepository repo;
	
	public List<Alternate_Component_Master> findAltCompByModelId(int id) {
		return repo.findAltCompByModelId(id);
	}
	
<<<<<<< HEAD
	public List<Alternate_Component_Master> findAltCompByComponentId(int id) {
		return repo.findAltCompByComponentId(id);
	}
=======
//	public List<Alternate_Component_Master> findAltCompByComponentId(int id) {
//		return repo.findAltCompByComponentId(id);
//	}
	
    public List<Alternate_Component_Master> getAllAlternateComponents() {
        return repo.findAll();
    }

    public Alternate_Component_Master saveAlternateComponent(Alternate_Component_Master altComponent) {
        return repo.save(altComponent);
    }
    
    public Alternate_Component_Master getAlternateComponentById(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Alternate Component not found with id: " + id));
    }

>>>>>>> Vehicle_Conf_Controller
}
