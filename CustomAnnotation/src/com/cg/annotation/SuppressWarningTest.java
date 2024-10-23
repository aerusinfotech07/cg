package com.cg.annotation;

import java.util.ArrayList;
import java.util.List;

//Java Program to illustrate SuppressWarnings Annotation

//Class 1
class DeprecatedTest
{
	@Deprecated
	public void Display()
	{
		System.out.println("Deprecatedtest display()");
	}
}

//Class 2 
public class SuppressWarningTest
{
	// If we comment below annotation, program generates
	// warning
	@SuppressWarnings({"checked", "deprecation"})
	public static void main(String args[])
	{
		@SuppressWarnings("rawtypes")
		List list=new ArrayList();
		list.add(20);
		
		DeprecatedTest d1 = new DeprecatedTest();
		d1.Display();
	}
}
