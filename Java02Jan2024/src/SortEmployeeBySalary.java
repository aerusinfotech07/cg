import java.util.Comparator;

public class SortEmployeeBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getSal()-o2.getSal());
	}
	

}
