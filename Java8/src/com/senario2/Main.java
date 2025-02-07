package com.senario2;

//Student Grades System
//Question: You have a list of students with their names and grades. Find the name of the student who has the highest grade.
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class Student {
    private String name;
    private double grade;
	public Student(String name, double grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public double getGrade() {
		return grade;
	}

  
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.5),
            new Student("Bob", 92.0),
            new Student("Charlie", 88.5)
        );
        
        
        //Collections.sort(students);
        double max=students.get(0).getGrade();
        String highGradeStudent="";
        for(Student std:students)
        	if(std.getGrade()>=max) {
        		max=std.getGrade();
        		highGradeStudent=std.getName();
        	}
        System.out.println(highGradeStudent);
        
        Comparator<Student> stuComp=(p1,p2)->{
        	return (int) (p1.getGrade()-p2.getGrade());
        };
        
        

        Student topStudent = students.stream()
            .max(Comparator.comparingDouble(Student::getGrade))
            .orElseThrow(NoSuchElementException::new);

        System.out.println("Student with the highest grade: " + topStudent.getName());
    }
}
