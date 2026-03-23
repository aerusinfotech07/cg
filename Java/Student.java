public class Student
{
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private float m1,m2,m3;
	float avg=0;
	String grade="Failed";
	
	
	public void setEmployee(int id,String firstName,String lastName,String dob,float m1,float m2,float m3)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.avg=(m1+m2+m3)/3;
		if(this.avg>=75)
			grade="Dist";
	
	}
	
	public void display()
	{
		System.out.println("Id="+id+" firstName="+firstName+" Lastname="+lastName+" DOB="+dob+" Avg="+avg);
	}
	
	

}