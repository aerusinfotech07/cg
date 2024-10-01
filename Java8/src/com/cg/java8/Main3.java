package com.cg.java8;

public class Main3 {

	public static void main(String[] args) {
		Calculation c1=(x,y)->x+y;
		
		int z=c1.sum(20, 30);
		System.out.println(z);

	}

}
