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

import com.cg.smms.entities.Employee;
import com.cg.smms.service.EmployeeService;

@RestController
@SuppressWarnings("unused")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/employee/")
	public List<Employee> listAll() {
		return service.listAll();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
		try {
			Employee obj = service.get(id);
			return new ResponseEntity<Employee>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/employee/")
	public void save(@RequestBody Employee obj) {
		service.save(obj);
	}

	// RESTful API method for Update operation
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> update(@RequestBody Employee obj, @PathVariable Integer id) {
		try {
			Employee exist = service.get(id);
			service.save(obj);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
