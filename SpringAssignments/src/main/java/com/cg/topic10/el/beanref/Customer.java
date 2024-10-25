package com.cg.topic10.el.beanref;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	@Value("#{addressBean}")
	private Address address;

	@Value("#{addressBean.country}")
	private String country;
	
	@Value("#{addressBean.getFullAddress('cg')}")
	private String fullAddress;

	//getter and setter methods
	
	@Override
	public String toString() {
		return "Customer [address=" + address + "\n, country=" + country
				+ "\n, fullAddress=" + fullAddress + "]";
	}

}

