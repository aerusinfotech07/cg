package com.cg.topic12.autowiring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer 
{
	//@Autowired field
	//@Autowired
	private Person person;
	private int type;
	private String action;
	
	
	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public Person getPerson() {
		return person;
	}


	//@Autowired setter method
	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
	
	//Autowired By Constructor
	/*@Autowired
	public Customer(Person person) {
		this.person = person;
	}*/
}
