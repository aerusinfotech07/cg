package com.cg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

	public static void main(String[] args) {
        String filePath = "example.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } 
        catch (FileNotFoundException e) {
            System.err.println("File is not exist");
        }
        catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

}
