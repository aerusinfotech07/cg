package com.cg.topic12.autowiring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new GenericXmlApplicationContext(
                new FileSystemResource("src/main/java/com/cg/topic5/scope/singleton/Spring-Customer.xml"));
    	
    	
    }
}