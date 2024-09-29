package com.cg;

public class MethodReference2{

	public MethodReference2(){  
        System.out.println("Thread is running...");  
    }  
	
	
	public static void main(String[] args) { 
		//MethodReference2 obj=;
        Thread t2=new Thread(MethodReference2::new);  
        t2.start();       
    }    

}
