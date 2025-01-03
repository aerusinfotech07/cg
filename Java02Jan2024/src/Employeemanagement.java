
public class Employeemanagement {

	public static void main(String[] args) {
		Employee e1=new Employee(101,"Ramesh","Sharma","Comp",200000);
		System.out.println(e1);
		Manager m1=new Manager(1033, "Sita", "Varma", "IT", 350000, 5000);
		System.out.println(m1);
		SalesEmployee se1=new SalesEmployee(107, "Satish", "ABC", "Sales", 25000, 200000, 10);
		System.out.println(se1);	
		
		//Polymorphic Ref
		Employee e3=new Manager();
		System.out.println(e3.getSal());
		if(e3 instanceof Manager)
		System.out.println(((Manager)e3).getComm());

	}

}
