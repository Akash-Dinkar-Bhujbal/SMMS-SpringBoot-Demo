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

import com.cg.smms.entities.Shop;
import com.cg.smms.service.ShopService;

@RestController
@SuppressWarnings("unused")
public class ShopController {
	@Autowired
	private ShopService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/shop/")
	public List<Shop> listAll() {
		return service.listAll();
	}

	@GetMapping("/shop/{id}/")
	public ResponseEntity<Shop> get(@PathVariable Integer id) {
		try {
			Shop obj = service.get(id);
			return new ResponseEntity<Shop>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/shop/")
	public void save(@RequestBody Shop obj) {
		service.save(obj);
	}

	// RESTful API method for Update operation
	@PutMapping("/shop/{id}/")
	public ResponseEntity<?> update(@RequestBody Shop obj, @PathVariable Integer id) {
		try {
			Shop exist = service.get(id);
			service.save(obj);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/shop/{id}/")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
