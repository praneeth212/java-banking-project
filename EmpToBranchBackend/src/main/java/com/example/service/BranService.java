package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entities.Branch;
import com.example.entities.Branches;
import com.example.repo.BranRepository;

@Service
public class BranService {
	
	@Autowired
	BranRepository bran;
	
	public Branches getAll() {
		Branches bs = new Branches(bran.findAll());
		return bs;
	}
	
	public Branch Bgetone(int id) {
		Branch b = bran.findById(id).get();
		return b;
	}
	
	public void Badd(Branch b) {
		bran.save(b);
	}
	
	public Branch Bupdate(int id, Branch bnew) {
		Branch b = bran.findById(id).get();
		b.setBranch_name(bnew.getBranch_name());
		b.setBranch_location(bnew.getBranch_location());
		b.setBranch_contact(bnew.getBranch_contact());
		bran.save(b);
		return b;
	}
	
	public void Bdelete(int id) {
		bran.deleteById(id);
	}

}
