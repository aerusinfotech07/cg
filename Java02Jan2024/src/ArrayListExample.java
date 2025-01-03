import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list=new Vector<>();
		list.add("Mumbai");
		list.add("Pune");
		list.add("Nasik");
		list.add("Indore");
		list.add("Mumbai");
		System.out.println(list);		
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
		
		
		
		
		
	}

}


///Collections basically has tree types
//1)List(Ordered)->ArrayList,LinkedList,Vector
//2)Set(Unique)->TreeSet(Sorted),HashSet(Unordered+Good For Fast Search),LinkedHashSet(Ordered)
//3)Map(Unique By Key)->TreeMap(Sorted By Key),HashMap(Unordered),LinkedHashMap(Ordered),Hashtable
