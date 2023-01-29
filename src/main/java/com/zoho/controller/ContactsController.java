package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entites.Contacts;
import com.zoho.entites.Lead;
import com.zoho.services.ContactService;

@Controller
public class ContactsController {
        
	@Autowired
	private ContactService contactService;
	    
	@RequestMapping("/listcontacts")
	public String ListAllContacts(Model model) {
 List<com.zoho.entities.Contacts> contact = contactService.getAllContacts();
			model.addAttribute("contact", contact);
			return "list_contacts";
		}
	@RequestMapping("/contactInfo")
	public String leadInfo(@RequestParam("id")long id, Model model) {
		com.zoho.entities.Contacts contacts = contactService.findContactById(id);
		model.addAttribute("contacts",contacts);
		return "contact_info";
}
}
