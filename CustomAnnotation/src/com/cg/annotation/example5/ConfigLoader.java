package com.cg.annotation.example5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
//This example illustrates how to create an annotation for configuration settings in a Java application.

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ConfigProperty {
    String key();
    String defaultValue() default "";
}

 class AppConfig {
    @ConfigProperty(key = "app.name", defaultValue = "My Application")
    private String appName;

    @ConfigProperty(key = "app.version", defaultValue = "1.0.0")
    private String appVersion;

    // Getters for properties
    public String getAppName() { return appName; }
    public String getAppVersion() { return appVersion; }
}



 public class ConfigLoader {
     public static void loadConfig(AppConfig config) {
         Map<String, String> properties = new HashMap<>();
         properties.put("app.name", "My Real Application"); // Simulating loaded property
         // Note: app.version will use default value

         for (Field field : AppConfig.class.getDeclaredFields()) {
             if (field.isAnnotationPresent(ConfigProperty.class)) {
                 ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                 String value = properties.getOrDefault(annotation.key(), annotation.defaultValue());
                 field.setAccessible(true);
                 try {
                     field.set(config, value);
                 } catch (IllegalAccessException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

     public static void main(String[] args) {
         AppConfig config = new AppConfig();
         loadConfig(config);
         System.out.println("App Name: " + config.getAppName());
         System.out.println("App Version: " + config.getAppVersion());
     }
 }

