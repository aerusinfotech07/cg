package com.cg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample7 {
	
	 public static void main(String[] args) {  
         
	        List<String> list=new ArrayList<String>();  
	        list.add("ankit");  
	        list.add("mayank");  
	        list.add("irfan");  
	        list.add("jai");  
	        
	        Collections.sort(list);
	        
	        
	        
	        list.forEach(data->{
	        	System.out.println(data);
	        });
	        
	        
	        
	 }

}
