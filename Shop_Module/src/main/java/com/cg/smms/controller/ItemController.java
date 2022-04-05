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

import com.cg.smms.entities.Item;
import com.cg.smms.service.ItemService;

@RestController
@SuppressWarnings("unused")
public class ItemController {
	@Autowired
	private ItemService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/item/")
	public List<Item> listAll() {
		return service.listAll();
	}

	@GetMapping("/item/{id}")
	public ResponseEntity<Item> get(@PathVariable Integer id) {
		try {
			Item obj = service.get(id);
			return new ResponseEntity<Item>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/item/")
	public void save(@RequestBody Item obj) {
		service.save(obj);
	}

	// RESTful API method for Update operation
	@PutMapping("/item/{id}")
	public ResponseEntity<?> update(@RequestBody Item obj, @PathVariable Integer id) {
		try {
			Item exist = service.get(id);
			service.save(obj);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/item/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
