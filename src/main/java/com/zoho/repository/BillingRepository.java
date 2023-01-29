package com.zoho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoho.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
