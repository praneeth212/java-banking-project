package com.example.entity;

import java.util.List;

public class Branches {
	
	private List<Branch> branchList;

	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branches(List<Branch> branchList) {
		super();
		this.branchList = branchList;
	}

	@Override
	public String toString() {
		return "Branches [branchList=" + branchList + "]";
	}

	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}

}
