package com.cg.topic2.config;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld {

	@Override
	public void printHelloWorld(String msg) {

		System.out.println("Hello : " + msg);
	}

}
