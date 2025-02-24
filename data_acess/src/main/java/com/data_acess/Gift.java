package com.data_acess;

import java.util.Objects;

public class Gift {
	
	private String name;
	private String gift;
	private int price;
	public Gift(String name, String gift, int price) {
		super();
		this.name = name;
		this.gift = gift;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gift, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gift other = (Gift) obj;
		return Objects.equals(gift, other.gift) && Objects.equals(name, other.name) && price == other.price;
	}
	@Override
	public String toString() {
		return "Gift [name=" + name + ", gift=" + gift + ", price=" + price + "]";
	}
	
	
	

}
