package com.cg.annotation;
//Java Program to Illustrate Override Annotation

//Class 1
class Base1
{
	@Deprecated
	public void Display()
	{
		System.out.println("Base display()");
	}
	
	public static void main(String args[])
	{
		
		Base1 t1 = new Derived1();
		t1.Display();
	}	 
}

//Class 2
//Extending above class 
class Derived1 extends Base1
{
	@Override
	public void Display()
	{
		System.out.println("Derived display()");
	}
}




