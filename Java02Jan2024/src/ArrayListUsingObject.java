import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListUsingObject {

	public static void main(String[] args) {
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(101,"Ramesh","Sharma","Comp",20000));
		empList.add(new Employee(102,"Rishabh","Sharma","Comp",15000));
		empList.add(new Employee(103,"Kavya","Varma","Comp",22000));
		empList.add(new Employee(104,"Purvi","Patil","Comp",21000));
		//System.out.println(empList);
		Collections.sort(empList,new SortEmployeeByFirstName());
		
		for(Employee temp:empList)
			System.out.println(temp);

	}

}
