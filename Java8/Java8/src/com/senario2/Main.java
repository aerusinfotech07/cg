package com.senario2;

//Student Grades System
//Question: You have a list of students with their names and grades. Find the name of the student who has the highest grade.

import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double grade;

    // Constructor, getters, and setters
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.5),
            new Student("Bob", 92.0),
            new Student("Charlie", 88.5)
        );

        Student topStudent = students.stream()
            .max(Comparator.comparingDouble(Student::getGrade))
            .orElseThrow(NoSuchElementException::new);

        System.out.println("Student with the highest grade: " + topStudent.getName());
    }
}
