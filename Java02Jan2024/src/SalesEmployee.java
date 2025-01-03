
public class SalesEmployee extends Employee
{
	private float amountOfProductSold;
	private float comm;
	private float commPer;
	public SalesEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesEmployee(int id, String firstName, String lastName, String dept, float sal,float amountOfProductSold,float commPer) {
		super(id, firstName, lastName, dept, sal);
		this.amountOfProductSold=amountOfProductSold;
		this.comm=(amountOfProductSold*commPer/100);
		this.commPer=commPer;
	}
	@Override
	public String toString() {
		return "SalesEmployee [amountOfProductSold=" + amountOfProductSold + ", comm=" + comm + ", commPer=" + commPer
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public float getSal() {
		return super.getSal()+(amountOfProductSold*commPer/100);
	}
	
	
		
	

}
