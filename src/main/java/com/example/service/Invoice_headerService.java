package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Invoice_header;
import com.example.repository.Invoice_headerRepository;

@Service
public class Invoice_headerService {
	@Autowired
	private Invoice_headerRepository repo;
	
	public Invoice_header findInvoice_headerByModelId(int id) {
		return repo.findInvoice_headerByModelId(id);
	}
	
	public Optional<Invoice_header> findById(int id) {
		return repo.findById(id);
	}
}
