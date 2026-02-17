package com.cg.topic14.aop1.adviceandpointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new GenericXmlApplicationContext(
                new FileSystemResource("src/main/java/com/cg/topic14/aop1/adviceandpointcut/Spring-Customer.xml"));
        
    	CustomerService cust = (CustomerService) context
				.getBean("customerServiceProxy");
		System.out.println("*************************");
		cust.printName();
		cust.printURL();
		
    	
    }
}