package com.cg.smms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.smms.entities.Customer;
import com.cg.smms.service.*;

@RestController
@SuppressWarnings("unused")
public class CustomerController {
	@Autowired
	private CustomerService service;

//RESTful API methods for Retrieval operations
	@GetMapping("/customer/")
	public List<Customer> get() {
		return service.listAll();
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id) {
		try {
			Customer obj = service.get(id);
			return new ResponseEntity<Customer>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/customer/")
	public void save(@RequestBody Customer obj) {
		service.save(obj);
	}

	// RESTful API method for Update operation
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> update(@RequestBody Customer shopOwner, @PathVariable Integer id) {
		try {
			Customer exist = service.get(id);
			service.save(shopOwner);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/customer/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
