package com.fdmGroup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "PartTime_employee")
public class PartTimeEmployee  extends Employee{
	
	@Column(name= "Wages", nullable = false)
	private double salary;


	public PartTimeEmployee(String empName, String empDesignation, double salary) {
		super(empName, empDesignation);
		this.salary = salary;
	}


	public  PartTimeEmployee() {
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
		return "PartTimeEmployee [salary=" + salary + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
	
	

}
