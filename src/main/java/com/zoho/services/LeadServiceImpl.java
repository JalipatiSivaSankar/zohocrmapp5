package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Lead;
import com.zoho.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);
		
	}


	@Override
	public List<Lead> getAllLeads() {
	         List<Lead> lead = leadRepo.findAll();
			return lead;
		
}
 

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
		
	}


	@Override
	public void deleteOneLead(long id) {
	          leadRepo.deleteById(id);
		
	}

}
