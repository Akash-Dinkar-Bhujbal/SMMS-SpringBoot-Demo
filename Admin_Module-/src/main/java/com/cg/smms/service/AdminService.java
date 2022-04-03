package com.cg.smms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.smms.entities.Admin;
import com.cg.smms.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository repo;

	public List<Admin> listAll() {
		return repo.findAll();
	}

	public Admin save(Admin admin) {
		repo.save(admin);
		return admin;
	}

	public Admin get(Integer id) {
		return repo.findById(id).get();
	}

	public Admin delete(Integer id) {
		Admin admin = repo.findById(id).get();
		repo.deleteById(id);
		return admin;
	}

}
