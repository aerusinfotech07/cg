import java.util.*;

public class ScannerExample
{
	public static void main(String []args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int x,y,z;
		System.out.println("Please Enter value of X");
		x=sc.nextInt();
		System.out.println("Please Enter value of Y");
		y=sc.nextInt();
		if(x>y)
		System.out.println("Value of "+x+" is Larger than "+y);
		else
			System.out.println("Value of "+y+" is Larger than "+x);
	}


}