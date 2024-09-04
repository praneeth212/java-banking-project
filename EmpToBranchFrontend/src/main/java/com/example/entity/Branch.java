package com.example.entity;

public class Branch {
	
	private int branch_id;
	private String branch_name;
	private String branch_location;
	private long branch_contact;
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int branch_id, String branch_name, String branch_location, long branch_contact) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.branch_location = branch_location;
		this.branch_contact = branch_contact;
	}
	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_name=" + branch_name + ", branch_location="
				+ branch_location + ", branch_contact=" + branch_contact + "]";
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_location() {
		return branch_location;
	}
	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}
	public long getBranch_contact() {
		return branch_contact;
	}
	public void setBranch_contact(long branch_contact) {
		this.branch_contact = branch_contact;
	}

}
