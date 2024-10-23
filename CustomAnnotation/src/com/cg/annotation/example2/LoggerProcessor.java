package com.cg.annotation.example2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {
    String value() default "Executing method";
}

 class Calculator {

    @LogExecution(value = "Adding two numbers")
    public int add(int a, int b) {
        return a + b;
    }

    @LogExecution(value = "Subtracting two numbers")
    public int subtract(int a, int b) {
        return a - b;
    }
}


 public class LoggerProcessor {
     public static void main(String[] args) {
         Calculator calculator = new Calculator();

         try {
             Method[] methods = Calculator.class.getDeclaredMethods();
             for (Method method : methods) {
                 if (method.isAnnotationPresent(LogExecution.class)) {
                     LogExecution log = method.getAnnotation(LogExecution.class);
                     System.out.println(log.value()); // Log the message

                     // Invoke the method
                     int result = (int) method.invoke(calculator, 10, 5);
                     System.out.println("Result: " + result);
                     System.out.println();
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }

