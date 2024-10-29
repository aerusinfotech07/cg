package com.cg.topic14.aop1.aspectJ;

public interface CustomerBo {

	void addCustomer();
	
	String addCustomerReturnValue();
	
	void addCustomerThrowException() throws Exception;
	
	void addCustomerAround(String name);
}