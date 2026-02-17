package com.cg.topic4.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
				"Spring-Module-basic.xml");

		
		
		Company company=(Company) context.getBean("company");
		System.out.println(company.getPeerson().getName());
		
		 
		
	}
}
