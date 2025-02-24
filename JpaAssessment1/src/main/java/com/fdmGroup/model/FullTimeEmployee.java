package com.fdmGroup.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name= "Fulltime_employee")
public class FullTimeEmployee extends Employee {
	
	@Column(nullable = false)
	private double salary;

	public FullTimeEmployee(String empName, String empDesignation, double salary) {
		super(empName, empDesignation);
		this.salary = salary;
	}


	public FullTimeEmployee() {
		super();
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
