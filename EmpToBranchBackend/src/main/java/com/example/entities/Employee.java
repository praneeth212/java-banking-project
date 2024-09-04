package com.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int emp_id;
	
	@Column(nullable=false)
	private String emp_name;
	private String emp_position;
	private double emp_salary;
	private String emp_contact;
	
	@ManyToOne
	@JsonBackReference
	private Branch bid;
//	
//	@ManyToOne
//	@JoinColumn(name = "branch_id")
//	@JsonBackReference
//	private Branch bid;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String emp_name, String emp_position, double emp_salary, String emp_contact,
			Branch bid) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_position = emp_position;
		this.emp_salary = emp_salary;
		this.emp_contact = emp_contact;
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_position=" + emp_position
				+ ", emp_salary=" + emp_salary + ", emp_contact=" + emp_contact + ", bid=" + bid + "]";
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_position() {
		return emp_position;
	}

	public void setEmp_position(String emp_position) {
		this.emp_position = emp_position;
	}

	public double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_contact() {
		return emp_contact;
	}

	public void setEmp_contact(String emp_contact) {
		this.emp_contact = emp_contact;
	}

	public Branch getBid() {
		return bid;
	}

	public void setBid(Branch bid) {
		this.bid = bid;
	}
}
