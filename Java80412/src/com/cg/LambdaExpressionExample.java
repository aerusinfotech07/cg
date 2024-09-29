package com.cg;

public class LambdaExpressionExample {

	public static void main(String[] args) {
		
		Drawable obj=new Drawable() {
			
			@Override
			public void draw() {
				System.out.println("Drawable Interface call method");
				
			}
		};		
		obj.draw();
		obj.offer();
		
		Drawable objlam=()->System.out.println("Drawable Interface call method Using Lambda Exp");
		
		
		objlam.draw();
		
		
		
		
		
		
		
	}

}
