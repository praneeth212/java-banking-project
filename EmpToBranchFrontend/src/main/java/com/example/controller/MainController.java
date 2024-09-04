package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Admin;
import com.example.entity.Branch;
import com.example.entity.Branches;
import com.example.entity.Employee;
import com.example.entity.Employees;

@Controller
public class MainController {
	
	RestTemplate rs = new RestTemplate();
	
//	Step:1
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
//	Step:2
	@GetMapping("/admin")
	public String adminLogin() {
		return "admin.html";
	}
	
//	Step:2.1
	@PostMapping(value="/adminlogin", consumes = "application/x-www-form-urlencoded")
	public String adminlogin(Admin ad) {
		if(ad.getPassword().equals("admin")) {
			return "options.html";
		}
		return "admin.html";
	}
	
	@GetMapping("/branchservice")
	public String branchService() {
		return "branch.html";
	}
	
	@GetMapping("/employeeservice")
	public String employeeService() {
		return "employee.html";
	}
	
//	Operations
	@GetMapping("/Bgetall")
	public ModelAndView getall() {
		ModelAndView mv = new ModelAndView("Bgetall.html");
		Branches bs = rs.getForObject("http://localhost:1158/branchservice/Bgetall", Branches.class);
		mv.addObject("bs", bs);
		return mv;
	}
	
	@GetMapping("/Egetall")
	public ModelAndView Egetall() {
		ModelAndView mv = new ModelAndView("Egetall.html");
		Employees bs = rs.getForObject("http://localhost:1158/employeeservice/Egetall", Employees.class);
		mv.addObject("bs", bs);
		return mv;
	}
	
	@PostMapping("/Badd")
	public String Badd(Branch b) {
		rs.postForLocation("http://localhost:1158/branchservice/Badd", b);
		return "branch.html";
	}
	
	@GetMapping("/Badd")
	public String BBadd() {
		return "Badd.html";
	}
	
	@PostMapping("/Eadd")
	public String Eadd(Employee e) {
		rs.postForLocation("http://localhost:1158/employeeservice/Eadd", e);
		return "branch.html";
	}
	
	@GetMapping("/Eadd")
	public String EEadd() {
		return "Eadd.html";
	}
	
	@GetMapping("/Bgetone")
	public String Bgetone() {
		return "Bgetone.html";
	}
	
	@GetMapping("/Egetone")
	public String Egetone() {
		return "Egetone.html";
	}
	
	@GetMapping("/Eget")
	public String Eget() {
		return "Eget.html";
	}
	
	@GetMapping("/Bupdate")
	public String Bupdate() {
		
		return "Bupdate.html";
	}
	
	@GetMapping("/Eupdate")
	public String Eupdate() {
		
		return "Eupdate.html";
	}
	
	@GetMapping("/Bdelete")
	public String Bdelete() {
		
		return "Bdelete.html";
	}
	
	@GetMapping("/Edelete")
	public String Edelete() {
		
		return "Edelete.html";
	}
	
	

}
