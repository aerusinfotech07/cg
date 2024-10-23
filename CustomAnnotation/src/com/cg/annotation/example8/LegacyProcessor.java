package com.cg.annotation.example8;
//Deprecated Method Annotations:You can create a custom annotation to indicate that a method is deprecated, along with a suggested replacement.
import java.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DeprecatedMethod {
    String replacement() default "";
}


class LegacyService {

    @DeprecatedMethod(replacement = "newMethod")
    public void oldMethod() {
        System.out.println("This is the old method.");
    }

    public void newMethod() {
        System.out.println("This is the new method.");
    }
}

public class LegacyProcessor {
    public static void main(String[] args) {
        LegacyService service = new LegacyService();
        Method[] methods = LegacyService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(DeprecatedMethod.class)) {
                DeprecatedMethod annotation = method.getAnnotation(DeprecatedMethod.class);
                System.out.println("Method " + method.getName() + " is deprecated. " +
                                   "Consider using: " + annotation.replacement());
            }
        }
    }
}

