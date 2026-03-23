public class Employee
{
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private float sal;
	
	public Employee()
	{
		this(0,"Unknown","Unknown","Unknown",0);
		
	}
	
	public Employee(int id,String firstName,String lastName,String dob,float sal)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.sal=sal;
	
	}
	
	public void display()
	{
		System.out.println("Id="+id+" firstName="+firstName+" Lastname="+lastName+" DOB="+dob);
	}
	
	
	public float getSal()
	{
		return this.sal;
	}
	
	

}