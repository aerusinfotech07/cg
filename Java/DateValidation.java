import java.util.*;

public class DateValidation
{
	public static void main(String []args)throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your Value in dd mm yyyy");
		int dd,mm,yyyy,no_of_days=0;
		dd=sc.nextInt();
		mm=sc.nextInt();
		yyyy=sc.nextInt();
		
		switch(mm)
		{
			case 1:case 3:case 5:case 7:case 10:case 12:
				no_of_days=31;
				break;
			case 4:case 6:case 8:case 9:case 11:
				no_of_days=30;
				break;	
			case 2:
				if(yyyy%4==0)
					no_of_days=29;
				else
					no_of_days=28;
			default:
					no_of_days=0;
					
			
			
		}
		
		if(dd>no_of_days || dd<no_of_days)
			System.out.println("Invalid Date");
		else
		System.out.println("Valid Date");
		
		
		
	}


}