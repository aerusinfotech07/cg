
public class Manager extends Employee{
	
	public float comm;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String firstName, String lastName, String dept, float sal,float comm) {
		super(id, firstName, lastName, dept, sal);
		this.comm=comm;
	}

	@Override
	public String toString() {
		return "Manager [comm=" + comm + ", toString()=" + super.toString() + "]";
	}
	
	public float getSal() {
		return super.getSal()+comm;
	}

	public float getComm() {
		return comm;
	}
	
	
	public Manager getEmployee()
	{
		return new Manager();
	}
	
	
	
	
	

}
