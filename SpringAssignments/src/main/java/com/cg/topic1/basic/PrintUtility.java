package com.cg.topic1.basic;

public class PrintUtility {
	
	Printable printable;
	
	/*public PrintUtility()
	{
		printable=new PrintPDF();
	}*/
	
	

	
	
	public void printUtility()
	{
		printable.print();
	}

	
	  public PrintUtility(Printable printable) { super(); this.printable =
	  printable; }
	 

	public void setPrintable(Printable printable) {
		this.printable = printable;
	}

}
