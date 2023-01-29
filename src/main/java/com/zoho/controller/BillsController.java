package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.zoho.services.BillingService;
import com.zoho.services.ContactService;

@Controller
public class BillsController {
	
	@Autowired
	private BillingService billingService;
	
	@Autowired 
	private ContactService contactService;
	
	   @RequestMapping("/billingForm")
       public String viewBillingForm(@RequestParam("contactId") long id, Model model) {
	    	 com.zoho.entities.Contacts contact = contactService.findContactById(id);
	    	  model.addAttribute("contact", contact);
	    	  return "create_bill";
	      }
	   @RequestMapping("/generateBill")
	    public String generateBill(@ModelAttribute("billing") com.zoho.entities.Billing billing) {
	    	 billingService.generateInvoice(billing);
			return "create_bill";
			
	    	 }
	   
	   @RequestMapping("/listAllBills")
	     public String listBills(Model model){
	    	 List<com.zoho.entities.Billing> allBills = billingService.getAllBills();
	    	 model.addAttribute("allBills", allBills);
			 return "list_bills";
}
}