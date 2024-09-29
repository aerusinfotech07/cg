import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	
}

public class ArrayListUserDefinedObjectExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("How Many Objects you want to starore");
        int x=sc.nextInt();
        for(int i=0;i<x;i++) {
        	System.out.println("Please Enter Name");
        	String name=sc.next();
        	System.out.println("Please Enter age");
        	int age=sc.nextInt();
        	users.add(new User(name, age));
        }
        //users.add(new User("John", 34));
        //users.add(new User("Steve", 29));
        //users.add("Hello");
        users.forEach(p->System.out.println("User details is "+p.getName()+" "+p.getAge()));
        
        Collections.sort(users,new SortUserByName());
        
        users.forEach(p->System.out.println("User details is "+p.getName()+" "+p.getAge()));
        
    }
}
