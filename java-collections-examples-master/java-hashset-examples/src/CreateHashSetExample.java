import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CreateHashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> daysOfWeek = new LinkedHashSet<>();

        // Adding new elements to the HashSet
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        // Adding duplicate elements will be ignored
        System.out.println(daysOfWeek.add("Monday"));

        System.out.println(daysOfWeek);
    }
}
