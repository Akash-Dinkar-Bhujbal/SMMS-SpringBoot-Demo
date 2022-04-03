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

import com.cg.smms.entities.Admin;
import com.cg.smms.service.AdminService;

@RestController
@SuppressWarnings("unused")
public class AdminController {

	@Autowired
	private AdminService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/Admins")
	public List<Admin> list() {
		return service.listAll();
	}

	@GetMapping("/Admins/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id) {
		try {
			Admin Admin = service.get(id);
			return new ResponseEntity<Admin>(Admin, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/Admins")
	public Admin add(@RequestBody Admin admin) {
		service.save(admin);
		return admin;
	}

	// RESTful API method for Update operation
	@PutMapping("/Admins/{id}")
	public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id) {
		try {
			Admin existAdmin = service.get(id);
			service.save(admin);
			System.out.println("Admin details updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/Admins/{id}")
	public ResponseEntity<?> delete(@RequestBody Admin admin, @PathVariable Integer id) {
		try {
			Admin existAdmin = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
