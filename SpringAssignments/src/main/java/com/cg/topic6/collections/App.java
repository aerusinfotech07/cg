package com.cg.topic6.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new GenericXmlApplicationContext(
                new FileSystemResource("src/main/java/com/cg/topic5/scope/prototype/Spring-Customer.xml"));
         
    	Customer cust = (Customer)context.getBean("CustomerBean");
    	System.out.println(cust);
    }
}