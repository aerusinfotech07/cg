package com.cg.annotation.example1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;



// Step 3: Access the annotations
public class UserProcessor {
	
    public static void main(String[] args) {
        User user = new User("Alice", 30);

        try {
            Method[] methods = User.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyCustomAnnotation1.class)) {
                	MyCustomAnnotation1 annotation = method.getAnnotation(MyCustomAnnotation1.class);
                    System.out.println("Method: " + method.getName());
                    System.out.println("Annotation Value: " + annotation.value());
                    System.out.println("Annotation Number: " + annotation.number());

                    // Invoke the method if it's a getter or display method
                    if (method.getName().startsWith("get") || method.getName().equals("displayUserInfo")) {
                        method.invoke(user);
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

