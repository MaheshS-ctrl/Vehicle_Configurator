	package com.example.service;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.example.entity.Invoice_detail;
	import com.example.repository.Invoice_detailRepository;
	
	@Service
	public class Invoice_detailService {
		@Autowired
		private Invoice_detailRepository repo;
		
		public List<Invoice_detail> findInvoice_detailById(int id) {
			return repo.findInvoice_detailById(id);
		}
		
		public List<Invoice_detail> findInvoice_detailsByCompId(int id) {
			return repo.findInvoice_detailsByCompId(id);
		}
	}
