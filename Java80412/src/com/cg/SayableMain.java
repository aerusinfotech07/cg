package com.cg;

public class SayableMain {

	public static void main(String[] args) {
		Sayable s1=(p1,p2)-> "Nothing To say to "+p1+" "+p2;		
		
		String op=s1.say("Vilas","Sangre");
		System.out.println(op);
	}

}
