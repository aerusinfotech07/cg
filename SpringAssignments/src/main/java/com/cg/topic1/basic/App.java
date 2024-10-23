package com.cg.topic1.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
				"Spring-Module-basic.xml");

		//HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		//obj.printHello();
		
		//Address address=(Address)context.getBean("address");
		
		//Employee emp=(Employee)context.getBean("emp");
		//emp.setAddress(address);

		//System.out.println(emp);
		//System.out.println(address);
		
		PrintUtility printUtility = (PrintUtility) context.getBean("printUtility");
		printUtility.printUtility();
		
	}
}
