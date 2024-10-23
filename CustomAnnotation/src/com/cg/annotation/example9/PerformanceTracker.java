package com.cg.annotation.example9;
//Performance Tracking Annotations:You can create an annotation to track the performance of methods, measuring execution time.
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TrackPerformance {
}

class MathOperations {

    @TrackPerformance
    public int computeFibonacci(int n) {
        if (n <= 1) return n;
        return computeFibonacci(n - 1) + computeFibonacci(n - 2);
    }
}


public class PerformanceTracker {
    public static void main(String[] args) {
        MathOperations operations = new MathOperations();
        Method[] methods = MathOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(TrackPerformance.class)) {
                long startTime = System.nanoTime();
                int result=0;
				try {
					result = (int) method.invoke(operations, 10);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Result: " + result);
                System.out.println("Execution time: " + duration + " nanoseconds");
            }
        }
    }
}

