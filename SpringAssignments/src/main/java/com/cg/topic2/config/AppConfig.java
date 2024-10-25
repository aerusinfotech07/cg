package com.cg.topic2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class AppConfig {
	
    @Bean(name="helloBean123")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
	
}