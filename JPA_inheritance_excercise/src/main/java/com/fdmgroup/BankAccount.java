package com.fdmgroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "FindAllBankAccount", query = "Select b From BankAccount b")
@DiscriminatorColumn(name = "ACCOUNT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Account_ID_GEN")
	@SequenceGenerator(name = "Account_ID_GEN", sequenceName = "Account_ID_SEQ")
	@Column(name= "account_id")
	private int id;
	@Column(nullable = false)
	private double balance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_customer_id")
	private BankCustomer customer;
	
	
	public BankAccount() {
		super();
		
	}
	
	
	public BankAccount(double balance,BankCustomer customer) {
		super();
		this.balance = balance;
		this.customer =customer;
		
	}

	public void deposit(double amount) {
		balance = balance + amount;
		
		
	}
	
public void withdraw(double amount) {
		
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public BankCustomer getCustomer() {
	return customer;
}

public void setCustomer(BankCustomer customer) {
	this.customer = customer;
}


@Override
public String toString() {
	return "BankAccount [id=" + id + ", balance=" + balance + ", customer=" + customer + "]";
}
	


	

}
