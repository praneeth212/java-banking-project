package com.example.controller;

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

import com.example.entities.Branch;
import com.example.entities.Branches;
import com.example.repo.BranRepository;
import com.example.service.BranService;

@RestController
@RequestMapping("/branchservice")
@CrossOrigin(origins="*")
public class BranController {
	
	@Autowired
	BranService bran;
	
	@GetMapping("/Bgetall")
	public Branches getAll() {
		return bran.getAll();
	}
	
	@CrossOrigin("http://localhost:1563")
	@GetMapping("/Bgetone/{id}")
	public Branch Bgetone(@PathVariable int id) {
		return bran.Bgetone(id);
	}
	
//	@CrossOrigin("http://localhost:1563")
	@PostMapping("/Badd")
	public void Badd(@RequestBody Branch b) {
	}
	
	@CrossOrigin("http://localhost:1563")
	@PutMapping("/Bupdate/{id}")
	public Branch Bupdate(@PathVariable int id, @RequestBody Branch bnew) {
		return bran.Bupdate(id, bnew);
	}
	
	@CrossOrigin("http://localhost:1563")
	@DeleteMapping("/Bdelete/{id}")
	public void Bdelete(@PathVariable int id) {
		bran.Bdelete(id);
	}
	

}
