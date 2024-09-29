import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CreateHashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> numberMapping = new HashMap<>();

        // Adding key-value pairs to a HashMap
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);
        numberMapping.put("Four", 4);
        numberMapping.put("Four", 4);
        
        
        
        numberMapping.keySet().stream().sorted().forEach(key->{
        	System.out.println(key+" "+numberMapping.get(key));
        });
        
        System.out.println(numberMapping);
        //Collections.sort(value);
        //System.out.println(value);
        
        //System.out.println(numberMapping.get("Three"));

        // Add a new key-value pair only if the key does not exist in the HashMap, or is mapped to `null`
        //numberMapping.putIfAbsent("Four", 4);

        //System.out.println(numberMapping);
    }
}
