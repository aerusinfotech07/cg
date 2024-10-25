package com.cg.topic12.autowiring.xml;

public class Customer {

private Person person;
	
	public Customer(Person person) {
		this.person = person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
}
