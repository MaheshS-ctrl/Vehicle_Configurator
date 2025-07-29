package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Manufacturer;
import com.example.service.ManufacturerService;
import com.example.service.SgMfgMasterService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/map")
public class SgMfgController {
//	private final ManufacturerService service;
	
//	@Autowired
//	public SgMfgController(ManufacturerService serv) {
//		this.service = serv;
//	}
//	
//	@GetMapping("/{mfg_id}")
//	public ResponseEntity<Optional<Manufacturer>> getManufacturerById(@PathVariable("mfg_id") int id){
//		Optional<Manufacturer> mfg = service.findById(id);
//		return ResponseEntity.ok(mfg);
//	}
//	
//	@GetMapping("/segment/{seg_id}")
//	public ResponseEntity<List<Manufacturer>> getMfgBySegmentId(@PathVariable("seg_id") int id){
//		List<Manufacturer> mfg = service.findManufacturersBySegmentId(id);
//		return ResponseEntity.ok(mfg);
//		}
	
	@Autowired
    private SgMfgMasterService sgMfgMasterService;

    @PostMapping("/{mfgId}/{segId}")
    public ResponseEntity<String> map(@PathVariable Integer mfgId, @PathVariable Integer segId) {
        sgMfgMasterService.mapManufacturerToSegment(mfgId, segId);
        return ResponseEntity.ok("Mapped Manufacturer " + mfgId + " to Segment " + segId);
    }
}
