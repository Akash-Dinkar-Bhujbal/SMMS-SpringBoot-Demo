package com.cg.smms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.smms.entities.ShopOwner;
import com.cg.smms.repository.ShopOwnerRepository;

@Service
@Transactional
public class ShopOwnerService {

	@Autowired
	private ShopOwnerRepository repo;

	public List<ShopOwner> listAll() {
		return repo.findAll();
	}

	public ShopOwner save(ShopOwner obj) {
		repo.save(obj);
		return obj;
	}

	public ShopOwner get(Integer id) {
		return repo.findById(id).get();
	}

	public ShopOwner delete(Integer id) {
		ShopOwner obj = repo.findById(id).get();
		repo.deleteById(id);
		return obj;
	}

}
