package com.cg.smms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.smms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
