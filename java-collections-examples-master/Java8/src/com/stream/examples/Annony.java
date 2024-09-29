package com.stream.examples;




public class Annony {

	public static void main(String[] args) {
		//Rectange r1=new Rectange();
		//r1.print();
		
		Printable r1=new Printable() {

			@Override
			public void print() {
				System.out.println("Rectangle");
				
			}
			
		};
		r1.print();
		
		Printable r2=()->System.out.println("Rectangle");
		r2.print();
		
		
		Addition sum1=(x,y)->System.out.println(x+y);
		
		Addition sum2=(x,y)->{
			int z=x+y;
			System.out.println(z);
		};
		
		sum2.add(2, 3);
		
		
		Multiply m1=(x,y)-> x*y;
		
		
		
		
		}
		

	}


