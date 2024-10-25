package com.cg.topic11.autoscanning.annotation.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new GenericXmlApplicationContext(
                new FileSystemResource("src/main/java/com/cg/topic5/scope/singleton/Spring-Customer.xml"));
        
    	CustomerService cust = (CustomerService)context.getBean("customerService");
    	System.out.println(cust);
    	
    }
}