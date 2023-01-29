package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.services.ContactService;
import com.zoho.services.LeadService;

@Controller
public class LeadController {
       
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	//http://localhost:8080/create
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String viewCreateForm() {
		return "create_lead";
		
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("l") Lead lead, Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		model.addAttribute("msg", "record is saved");
		return "lead_info";
		
	}
	@RequestMapping("/listLeads")
	public String listAllLeads(Model model) {
		List<Lead> lead =leadService.getAllLeads();
		model.addAttribute("lead", lead);
		return "list_leads";
		
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		Contacts contacts=new Contacts();
		contacts.setFirstName(lead.getFirstName());
		contacts.setLastName(lead.getLastName());
		contacts.setEmail(lead.getEmail());
		contacts.setMobile(lead.getMobile());
		contacts.setSource(lead.getSource());
		
		contactService.saveOneContact(contacts);
		leadService.deleteOneLead(id);
		 java.util.List<Contacts> contact = contactService.getAllContacts();
		model.addAttribute("contact", contact);
		return "list_contacts";
		
	}
}
