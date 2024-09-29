package com.cg;

import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  

public class LambdaExpressionExample10 {

	public static void main(String[] args) {
		 List<Product> list=new ArrayList<Product>();          
	        //Adding Products  
	        list.add(new Product(1,"HP Laptop",25000f));  
	        list.add(new Product(3,"Keyboard",300f));  
	        list.add(new Product(2,"Dell Mouse",150f));  
	          
	        System.out.println("Sorting on the basis of name..."); 
	        
	        Collections.sort(list,(o1,o2)->{
	        	return o1.getId()-o2.getId();	        	
	        });
	        
	        list.forEach(data->{
	        	System.out.println(data);
	        });
	        

	}

}
