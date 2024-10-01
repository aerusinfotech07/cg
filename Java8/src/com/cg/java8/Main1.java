package com.cg.java8;

public class Main1 {

	public static void main(String[] args) {
		
		Drawable d1=new Drawable() {
			
			@Override
			public void draw() {
				System.out.println("Anno Class of Drwable");
				
			}
		};
		
		d1.draw();
		
		Drawable d2=()->System.out.println("Lambda Expression of Drawable");
		d2.draw();
		
		
		

	}

}
