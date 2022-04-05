package com.cg.smms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.smms.entities.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
