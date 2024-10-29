package com.cg.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String getHelloGreet()
	{
		return "Hello Greet";
	}
	
	@GetMapping("/hello")
	public String getHelloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/greet/{name}/{age}")
	public String greet(@PathVariable String name,@PathVariable Integer age)
	{
		return "Hello "+name+" Age"+age;
	}
	

}
