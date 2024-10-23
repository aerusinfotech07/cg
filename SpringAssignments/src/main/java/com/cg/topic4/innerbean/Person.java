package com.cg.topic4.innerbean;

public class Person 
{
	private String name;
	private String address;
	private int age;
	
	//getter and setter methods
	
	@Override
	public String toString() {
		return "Person [address=" + address + ",age=" + age + ", name=" + name + "]";
	}	
}
