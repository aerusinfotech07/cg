package com.cg.annotation.example7;
//Event Handling Annotations:Let's create an annotation to mark methods that should handle specific events in an application.

import java.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface EventHandler {
    String event();
}

class EventProcessor {

    @EventHandler(event = "USER_REGISTERED")
    public void onUserRegistered(String username) {
        System.out.println("User registered: " + username);
    }

    @EventHandler(event = "USER_LOGGED_IN")
    public void onUserLoggedIn(String username) {
        System.out.println("User logged in: " + username);
    }
}


public class EventHandlerProcessor {
    public static void main(String[] args) {
        EventProcessor processor = new EventProcessor();
        triggerEvent(processor, "USER_REGISTERED", "Alice");
        triggerEvent(processor, "USER_LOGGED_IN", "Alice");
    }

    public static void triggerEvent(EventProcessor processor, String event, String data) {
        Method[] methods = EventProcessor.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                EventHandler annotation = method.getAnnotation(EventHandler.class);
                if (annotation.event().equals(event)) {
                    try {
                        method.invoke(processor, data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


