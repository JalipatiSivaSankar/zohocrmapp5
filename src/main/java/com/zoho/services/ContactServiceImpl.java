package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.repository.ContactsRepository;
import com.zoho.repository.LeadRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactsRepository contactRepo;
	
	
	
	@Override
	public void saveOneContact(Contacts contacts) {
		contactRepo.save(contacts);
		
	}



	@Override
	public Contacts findContactById(long id) {
		          Optional<Contacts> findById = contactRepo.findById(id);
		          Contacts contacts = findById.get();
		          
		return  contacts;
	}



	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactRepo.findAll();
		return contacts;
	}	
		
	}


