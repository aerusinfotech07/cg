public class Manager extends Employee
{
	public float comm;
	
	public Manager()
	{}
	
	public Manager(int id,String firstName,String lastName,String dob,float sal,float comm)
	{
			super(id,firstName,lastName,dob,sal);
			this.comm=comm;
	}
	
	public void display()
	{
		super.display();
		System.out.println("Comm="+comm);
	}

	public float getSal()
	{
		return this.getSal()+comm;
	}

}