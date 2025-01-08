package com.cg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionExample1 {
	
	public static void main(String args[])
	{
		
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
			int x=10/0;
			String arr[]=new String[2];
		
			System.out.println("Pleasde Enter Name");
			String name=br.readLine();
			System.out.println("Please enter age ");
			int age=Integer.parseInt(br.readLine());
			System.out.println(name);
			System.out.println(age);
			//System.out.println(arr[3]);
		}
		catch(IOException ex)
		{
			System.out.println("Issue with IO");
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Please enter correct value for age");
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println("Please enter correct value for age");
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(RuntimeException ex)
		{
			System.out.println("RunTime Exception occured");
			if(ex instanceof StringIndexOutOfBoundsException)
				throw new StringIndexOutOfBoundsException("Hey String Index i could handle");
		}
		finally
		{
			
			System.out.println("Finally Always Execute");
		}
		
	}

}
