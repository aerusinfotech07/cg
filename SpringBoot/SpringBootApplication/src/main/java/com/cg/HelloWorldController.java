package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	HelloWorld helloWorld;
	
	@GetMapping("/")
	public String getMessage()
	{
		
		return helloWorld.display();
	}

}
