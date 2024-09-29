import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IterateOverHashMap {
    public static void main(String[] args) {
        Map<String, Double> employeeSalary = new HashMap<>();
        employeeSalary.put("David", 76000.00);
        employeeSalary.put("John", 120000.00);
        employeeSalary.put("Mark", 95000.00);
        employeeSalary.put("Steven", 134000.00);
        
        employeeSalary.entrySet().forEach(p->{
        	System.out.println(p.getKey()+" "+p.getValue());
        });
        
        for(Map.Entry<String,Double>  temp: employeeSalary.entrySet())
        {
        	System.out.println(temp.getKey()+" "+temp.getValue());
        }
        
        
      
    }
}
