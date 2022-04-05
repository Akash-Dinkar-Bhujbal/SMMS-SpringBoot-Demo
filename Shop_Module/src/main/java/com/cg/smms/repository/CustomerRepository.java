package com.cg.smms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.smms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
