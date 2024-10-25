package com.cg.topic2.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 
public class App {
	public static void main(String[] args) {
	    
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


	    HelloWorld obj = (HelloWorld) context.getBean("helloBean123");
	    
	    obj.printHelloWorld("Spring3 Java Config");

	}
}
