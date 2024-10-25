package com.cg.topic10.el.method;


import org.springframework.stereotype.Component;

@Component("priceBean")
public class Price {

	public double getSpecialPrice() {
		return new Double(99.99);
	}

}

