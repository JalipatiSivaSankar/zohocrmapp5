package com.zoho.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.zoho.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
