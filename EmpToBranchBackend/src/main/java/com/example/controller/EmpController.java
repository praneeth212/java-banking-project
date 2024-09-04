package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Branches;
import com.example.entities.Employee;
import com.example.entities.Employees;
import com.example.repo.BranRepository;
import com.example.repo.EmpRepository;

@RestController
@RequestMapping("/employeeservice")
public class EmpController {
	
	@Autowired
	EmpRepository emp;
	
	@Autowired
	BranRepository bran;
	
	@GetMapping("/Egetall")
	public Employees getAll() {
	    List<Employee> employeeList = emp.findAll();
	    return new Employees(0, employeeList); // Assuming 0 for bid since it's not relevant for all employees
	}
	
	@CrossOrigin("http://localhost:1563")
	@GetMapping("/Egetone/{id}")
	public Employee Egetone(@PathVariable int id) {
		Employee e = emp.findById(id).get();
		return e;
	}
	
	@CrossOrigin("http://localhost:1563")
	@GetMapping("/Eget/{id}")
	public Employees get(@PathVariable int id) {
		Employees es = new Employees();
		es.setBid(id);
		es.setEmpList(emp.filterByBid(bran.findById(id).get()));
		return es;
	}
	
	@PostMapping("/Eadd")
	public void add(@RequestBody Employee e) {
		emp.save(e);
	}
	
	@CrossOrigin("http://localhost:1563")
	@PutMapping("/Eupdate/{id}")
	public Employee update(@PathVariable int id, @RequestBody Employee enew) {
		Employee e = emp.findById(id).get();
		e.setEmp_name(enew.getEmp_name());
		e.setEmp_position(enew.getEmp_position());
		e.setEmp_salary(enew.getEmp_salary());
		e.setEmp_contact(enew.getEmp_contact());
		e.setBid(enew.getBid());
		emp.save(e);
		return e;
	}
	
	@CrossOrigin("http://localhost:1563")
	@DeleteMapping("/Edelete/{id}")
	public void delete(@PathVariable int id) {
		emp.deleteById(id);
	}
}