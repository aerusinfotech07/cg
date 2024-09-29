package com.cg;

public class LambdaExpressionExample9 {

	public static void main(String[] args) {
			
		Thread t1=new Thread(()->{
			System.out.println("Runnable Run Method");				
		});
		t1.start();
		
	}

}
