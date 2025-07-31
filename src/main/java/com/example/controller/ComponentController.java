package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ComponentService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/components")
public class ComponentController {
	@Autowired
	public ComponentService service;
	
}
