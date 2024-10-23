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

	public void setPrintable(Printable printable) {
		this.printable = printable;
	}

}
