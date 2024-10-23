package com.cg.annotation.example4;

import java.lang.reflect.Method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RequiresRole {
    String value();
}


class AdminService {

    @RequiresRole("ADMIN")
    public void deleteUser(int userId) {
        System.out.println("User " + userId + " deleted.");
    }

    @RequiresRole("USER")
    public void viewUser(int userId) {
        System.out.println("Viewing user " + userId);
    }
}

public class AuthorizationProcessor {
    public static void authorize(Object obj, String role) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequiresRole.class)) {
                RequiresRole annotation = method.getAnnotation(RequiresRole.class);
                if (!annotation.value().equals(role)) {
                    System.out.println("Access denied to method: " + method.getName());
                    return;
                }
                // Invoke the method if access is granted
                try {
                    method.invoke(obj, 1); // Example userId
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        authorize(adminService, "USER"); // This will deny access to deleteUser
        authorize(adminService, "ADMIN"); // This will allow access to deleteUser
    }
}

