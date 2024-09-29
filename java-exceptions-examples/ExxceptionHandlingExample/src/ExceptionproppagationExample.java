
public class ExceptionproppagationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ExceptionproppagationExample().display1();
	}
	
	
	public void display1()
	{
		System.out.println("Display1");
		try {
			display2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void display2() throws Exception
	{
		System.out.println("Display2");
		display3();
	}
	
	public void display3()throws Exception
	{
		System.out.println("Display3");
		display4();
	}
	
	public void display4() throws Exception
	{
		
		System.out.println("Display4");
		try {
		int x[]=new int[6];
		System.out.println(x[7]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("This Issue i can't handle");
			throw new Exception("Please Correct this issue at your end");
		}
	}

}
