package com.cg.topic10.el.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {

	@Value("itemA") //inject String directly
	private String name;

	@Value("10") //inject interger directly
	private int qty;

	public String getName() {
		return name;
	}

	//...
}
