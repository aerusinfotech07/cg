import java.util.*;

public class GradeCal
{
	public static void main(String []args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your percentage");
		int per=0;
		per=sc.nextInt();
		if(per>=75 && per<=100)
			System.out.println("Dist");
		else if(per>=60 && per<=74)
			System.out.println("First");
		else if(per>=45 && per<=59)
			System.out.println("Sec");
		else
			System.out.println("Failed");
	}


}