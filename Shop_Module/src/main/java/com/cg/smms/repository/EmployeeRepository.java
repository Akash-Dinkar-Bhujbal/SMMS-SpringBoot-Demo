package com.cg.smms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.smms.entities.Employee;

@SuppressWarnings("unused")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//	public List<Employee> findByShopId(Integer shopId);
}
