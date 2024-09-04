package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
@ToString
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int branch_id;
	
	@Column(unique=true, nullable=false)
	private String branch_name;
	@Column(nullable=false)
	private String branch_location;
	private long branch_contact;
	
//	@OneToMany(mappedBy="bid", fetch=FetchType.EAGER)
//	@OnDelete(action=OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private List<Employee> employees = new ArrayList<Employee>();
	
	
	@OneToMany(mappedBy = "bid", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
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
