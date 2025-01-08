package com.cg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MultipleResourcesExample {
    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
        String inputFilePath = "example.txt";
        String outputFilePath = "output.txt";

        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outputFilePath,true)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error handling the files: " + e.getMessage());
        }
    }
}

