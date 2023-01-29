package com.zoho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	private com.zoho.repository.BillingRepository billingRepo;
	
	
	@Override
	public void generateInvoice(com.zoho.entities.Billing billing) {
		billingRepo.save(billing);
		
	}

	@Override
	public List<com.zoho.entities.Billing> getAllBills() {
		List<com.zoho.entities.Billing> bills = billingRepo.findAll();
		return bills;
	}

		
	}


