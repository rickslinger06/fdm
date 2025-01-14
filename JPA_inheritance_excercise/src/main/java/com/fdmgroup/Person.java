package com.fdmgroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Person extends BankCustomer{
	
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	
	
	
	public Person() {}
	
	

	public Person(String address,String firstName, String lastName) {
		super(address);
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
	
}
