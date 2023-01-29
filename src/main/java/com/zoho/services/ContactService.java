package com.zoho.services;

import java.util.List;

import com.zoho.entities.Contacts;


public interface ContactService{
     

	void saveOneContact(Contacts contacts);
	

	public Contacts findContactById(long id);

	

	

	List<Contacts> getAllContacts();

	
}
