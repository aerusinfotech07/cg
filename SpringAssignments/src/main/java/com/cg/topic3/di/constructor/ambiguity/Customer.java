package com.cg.topic3.di.constructor.ambiguity;

public class Customer 
{
	private String name;
	private String address;
	private int age;
	
	public Customer(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public Customer(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	//getter and setter methods
	public String toString(){
		return " name : " +name + "\n address : "
               + address + "\n age : " + age;
	}

}
