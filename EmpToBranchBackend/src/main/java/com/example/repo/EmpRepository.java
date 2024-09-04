package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Branch;
import com.example.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{
	@Query(value="select e from Employee e where e.bid = ?1")
	public List<Employee> filterByBid(Branch id);
}
