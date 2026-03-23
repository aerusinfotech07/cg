import java.io.BufferedReader;
import java.io.InputStreamReader;
public class HelloWorld
{
	public static void main(String []args)throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int x,y,z;
		System.out.println("Please Enter value of X");
		x=Integer.parseInt(br.readLine());
		System.out.println("Please Enter value of Y");
		y=Integer.parseInt(br.readLine());
		z=x+y;
		System.out.println("Sum of "+x+" and "+y+" is "+z);
	}


}