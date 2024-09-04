package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Branch;
import com.example.entities.Employee;

public interface BranRepository extends JpaRepository<Branch, Integer>{

}
