package com.cg.annotation.example1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyCustomAnnotation {
    String value() default "Default Value";
    int number() default 0;
}

// Step 2: Use the annotation
class MyClass {

    @MyCustomAnnotation(value = "Hello, World!", number = 42)
    public void myAnnotatedMethod() {
        System.out.println("This is an annotated method.");
    }
}

// Step 3: Access the annotation at runtime
public class AnnotationProcessor {

    public static void main(String[] args) {
        try {
            Method method = MyClass.class.getMethod("myAnnotatedMethod");
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("Value: " + annotation.value());
                System.out.println("Number: " + annotation.number());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

