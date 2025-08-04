package com.example.controller;

import com.example.entity.Alternate_Component_Master;
import com.example.service.Alternate_Component_MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alternate-components")
public class AlternateComponentMasterController {

    @Autowired
    private Alternate_Component_MasterService service;
    
    

    @GetMapping("/all")
    public List<Alternate_Component_Master> getAllAlternateComponents() {
        return service.getAllAlternateComponents();
    }

    @PostMapping("/save")
    public Alternate_Component_Master saveAlternateComponent(@RequestBody Alternate_Component_Master altComponent) {
        return service.saveAlternateComponent(altComponent);
    }
    
    @GetMapping("/get/{id}")
    public Alternate_Component_Master getAlternateComponentById(@PathVariable int id) {
        return service.getAlternateComponentById(id);
    }
    
    @GetMapping("/model/{id}")
    public ResponseEntity<List<Alternate_Component_Master>> getAlternateComponentsByModelId(@PathVariable int id) {
        List<Alternate_Component_Master> components = service.findAltCompByModelId(id);

        if (components.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(components);
    }

}
