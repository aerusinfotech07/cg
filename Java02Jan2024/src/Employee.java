
public class Employee {
	//Type of variable in class
	//1)Instance Variable or non static variable 2)Class variable or Static variable 3)Local variable
	
	private int id;
	private String firstName;
	private String lastName;
	private String dept;
	private float sal;

	
	public Employee() {
		this(0,"Unknown","Unknown","",0.0f);
	}
	public Employee(int id, String firstName, String lastName, String dept, float sal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", sal=" + sal + "]";
	}
	public float getSal() {
		return sal;
	}
	
	
	public Employee getEmployee()
	{
		return new Employee();
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDept() {
		return dept;
	}
	
	
	

}
