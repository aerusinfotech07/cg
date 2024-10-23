package com.cg.annotation.example1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Step 1: Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyCustomAnnotation1 {
 String value() default "Default Value";
 int number() default 0;
 int length() default 0;
}
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyCustomAnnotation1(value = "User's name", number = 1,length = 20)
    public String getName() {
        return name;
    }

    @MyCustomAnnotation1(value = "User's age", number = 2,length = 2)
    public int getAge() {
        return age;
    }

    @MyCustomAnnotation1(value = "Display user info", number = 3)
    public void displayUserInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void display()
    {
    	System.out.println("Display Method ");
    }
}

