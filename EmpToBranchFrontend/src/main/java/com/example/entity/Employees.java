package com.example.entity;

import java.util.List;

public class Employees {
	
	private int bid;
	private List<Employee> empList;
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int bid, List<Employee> empList) {
		super();
		this.bid = bid;
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Employees [bid=" + bid + ", empList=" + empList + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	

}
