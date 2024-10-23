package com.cg.annotation.example6;
//Configuration Annotations:Let's create an annotation that specifies configuration settings for a class, such as database connection parameters.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Config {
    String url();
    String username();
    String password();
}

@Config(url = "jdbc:mysql://localhost:3306/mydb", username = "root", password = "password")
class DatabaseConnector {

    public void connect() {
        Config config = this.getClass().getAnnotation(Config.class);
        System.out.println("Connecting to database...");
        System.out.println("URL: " + config.url());
        System.out.println("Username: " + config.username());
        // In a real application, you would use the password to connect to the database
    }
}

public class DatabaseConnectorProcessor {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.connect();
    }
}

