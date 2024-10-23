package com.cg.annotation.example3;

import java.lang.reflect.Field;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
	String message() default "Field cannot be null";
}

class User {
	@NotNull(message = "Name is required")
	private String name;

	public User(String name) {
		this.name = name;
	}
}

public class ValidationProcessor {
	public static void validate(Object obj) {
		Class<?> objClass = obj.getClass();
		for (Field field : objClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(NotNull.class)) {
				NotNull annotation = field.getAnnotation(NotNull.class);
				field.setAccessible(true);
				try {
					if (field.get(obj) == null) {
						System.out.println(annotation.message());
					}
					else
						System.out.println(field.get(obj).toString());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		User user = new User("Ramesh"); // This will trigger validation
		validate(user);
	}
}
