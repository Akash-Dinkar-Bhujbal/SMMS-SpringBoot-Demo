package com.cg.smms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.smms.entities.User;
import com.cg.smms.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> listAll() {
		return repo.findAll();
	}

	public User save(User user) {
		repo.save(user);
		return user;
	}

	public User get(Integer id) {
		return repo.findById(id).get();
	}

	public User delete(Integer id) {
		User user = repo.findById(id).get();
		repo.deleteById(id);
		return user;
	}

}
