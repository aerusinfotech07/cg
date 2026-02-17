
package com.cg.topic11.autoscanning.annotation;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO //bean name become customerDAO
{
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}	
}
