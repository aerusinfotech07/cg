import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("Mumbai", "Mumbai Is Capital of India");
		map.put("Pune", "Pune Is Capital of India");
		map.put("Nashik", "Nashik Is Capital of India");
		map.put("Indore", "Indore Is Capital of India");
		//keySet
		Set<String> keys=map.keySet();
		for(String key:keys)
			System.out.println(key+" : "+map.get(key));
		
		
		
		for(Map.Entry<String, String> temp:map.entrySet())
		{
			System.out.println(temp.getKey()+" "+temp.getValue());
		}
		
		
		
			
		

	}

}
