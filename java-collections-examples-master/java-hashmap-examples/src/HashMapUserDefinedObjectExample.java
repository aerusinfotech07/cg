import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Employee {
    private Integer id;
    private String name;
    private String city;

    public Employee(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

public class HashMapUserDefinedObjectExample {
    public static void main(String[] args) {

        Map<Integer, Employee> employeesMap = new HashMap<>();
        employeesMap.put(1001, new Employee(1001, "Rajeev", "Bengaluru"));
        employeesMap.put(1002, new Employee(1002, "David", "New York"));
        employeesMap.put(1003, new Employee(1003, "Jack", "Paris"));
        
        /*employeesMap.forEach((k,v)->{
        	System.out.println(k+" "+v.getCity());
        });*/
        
       //Annonomies Class 
        Comparator<Employee> comp1=new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		Comparator<Employee> comp2=(o1,o2)->{
			return o1.getName().compareTo(o2.getName());
		};
		
		Comparator<Employee> comp3=(o1,o2)->o1.getName().compareTo(o2.getName());
		
		Comparator<Employee> comp4= Comparator.comparing(Employee::getName);	
		
		
        employeesMap.values().stream().sorted(Comparator.comparing(Employee::getName)).forEach(data->{
        	System.out.println(data.getName());
        });
        
        System.out.println(employeesMap);
    }
}
