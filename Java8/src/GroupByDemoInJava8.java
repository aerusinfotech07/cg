
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;  
public class GroupByDemoInJava8   
{  
    /* Driver Code */  
    public static void main(String args[]) throws IOException   
    {  
        List<Employee> emp = new ArrayList<>();  
        emp.add(new Employee("Dipak", "Delhi", 21));  
        emp.add(new Employee("Sumit", "Delhi", 21));  
        emp.add(new Employee("Karan", "Delhi", 23));  
        emp.add(new Employee("Mona", "Udaipur", 23));  
        emp.add(new Employee("Rajesh", "Banglore", 23));  
        emp.add(new Employee("Niraj", "Banglore", 31));          
        /* Group by Employees by city before Java 8 world */         
        Map<String,List<Employee>> EmpByCity = new HashMap<>();  
          
        
        /* group objects of Employee class in Java 8 */  
        EmpByCity =  emp.stream().collect(Collectors.groupingBy(Employee::getCity));  
        System.out.println("Employees grouped by cities in Java 8: " + EmpByCity);  
        /* group Employees by age */  
        Map<Integer,List<Employee>> EmpByAge = emp.stream().collect(Collectors.groupingBy(Employee::getAge));  
        System.out.println("Employees grouped by age in Java 8: " + EmpByAge);
        
        Map<String, Long> result = emp.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println("Employees grouped by age in Java 8: " + result);
    
        
    }  
}  
class Employee  
{  
    private String name;  
    private String city;  
    private int age;  
    public Employee(String name, String city, int age)   
    {  
        this.name = name;  
        this.city = city;  
        this.age = age;  
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
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    @Override  
    public String toString() {  
        return String.format("%s(%s,%d)", name, city, age);  
    }  
    @Override  
    public int hashCode() {  
        int hash = 7;  
        hash = 79 * hash + Objects.hashCode(this.name);  
        hash = 79 * hash + Objects.hashCode(this.city);  
        hash = 79 * hash + this.age;  
        return hash;  
    }  
    @Override  
    public boolean equals(Object obj) {  
        if (obj == null) {  
            return false;  
        }  
        if (getClass() != obj.getClass()) {  
            return false;  
        }  
        final Employee other = (Employee) obj;  
        if (!Objects.equals(this.name, other.name)) {  
            return false;  
        }  
        if (!Objects.equals(this.city, other.city)) {  
            return false;  
        }  
        if (this.age != other.age) {  
            return false;  
        }  
        return true;  
    }  
}  