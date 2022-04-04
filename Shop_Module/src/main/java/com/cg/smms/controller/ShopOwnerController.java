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

import com.cg.smms.entities.ShopOwner;
import com.cg.smms.service.ShopOwnerService;

@RestController
@SuppressWarnings("unused")
public class ShopOwnerController {

	@Autowired
	private ShopOwnerService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/shopOwner/")
	public List<ShopOwner> list() {
		return service.listAll();
	}

	@GetMapping("/shopOwner/{id}")
	public ResponseEntity<ShopOwner> get(@PathVariable Integer id) {
		try {
			ShopOwner obj = service.get(id);
			return new ResponseEntity<ShopOwner>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/shopOwner/")
	public ShopOwner add(@RequestBody ShopOwner obj) {
		service.save(obj);
		return obj;
	}

	// RESTful API method for Update operation
	@PutMapping("/shopOwner/{id}/")
	public ResponseEntity<?> update(@RequestBody ShopOwner obj, @PathVariable Integer id) {
		try {
			ShopOwner exist = service.get(id);
			service.save(obj);
			System.out.println("Shop Owner details updated");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/shopOwner/{id}/")
	public ResponseEntity<?> delete(@RequestBody ShopOwner obj, @PathVariable Integer id) {
		try {
			ShopOwner exist = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
