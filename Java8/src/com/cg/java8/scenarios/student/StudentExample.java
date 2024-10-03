package com.cg.java8.scenarios.student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum Major {
    COMPUTER_SCIENCE, MATHEMATICS, PHYSICS, ENGINEERING
}

class Student {
    private String name;
    private int age;
    private Major major;
    private double gpa;

    public Student(String name, int age, Major major, double gpa) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Major getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", major=" + major + ", gpa=" + gpa + '}';
    }
}

public class StudentExample {

    // Method to provide a list of Students
    private List<Student> getStudents() {
        return List.of(
                new Student("Alice", 20, Major.COMPUTER_SCIENCE, 3.8),
                new Student("Bob", 22, Major.MATHEMATICS, 3.5),
                new Student("Charlie", 21, Major.PHYSICS, 3.6),
                new Student("Diana", 23, Major.ENGINEERING, 3.9),
                new Student("Ethan", 24, Major.COMPUTER_SCIENCE, 2.8),
                new Student("Fiona", 19, Major.MATHEMATICS, 3.1),
                new Student("George", 26, Major.PHYSICS, 3.2),
                new Student("Hannah", 20, Major.ENGINEERING, 3.7)
        );
    }

    public void runExamples() {
        List<Student> studentList = getStudents();

        // 1. Filter: Find all students with GPA greater than 3.5
        List<Student> highGpaStudents = studentList.stream()
                .filter(student -> student.getGpa() > 3.5)
                .collect(Collectors.toList());
        System.out.println("Students with GPA greater than 3.5: " + highGpaStudents);

        // 2. Map: Count students aged 22 or older
        long countOlderStudents = studentList.stream()
                .filter(student -> student.getAge() >= 22)
                .count();
        System.out.println("Number of students aged 22 or older: " + countOlderStudents);

        // 3. FlatMap: Get all names of students in Computer Science
        String csStudentNames = studentList.stream()
                .filter(student -> student.getMajor().equals(Major.COMPUTER_SCIENCE))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Names of students in Computer Science: " + csStudentNames);

        // 4. Distinct: Get unique majors of students
        String uniqueMajors = studentList.stream()
                .map(Student::getMajor)
                .distinct()
                .map(Enum::name)
                .collect(Collectors.joining(", "));
        System.out.println("Unique majors of students: " + uniqueMajors);

        // 5. Sorted: Sort students by GPA
        List<Student> sortedByGpa = studentList.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
        System.out.println("Students sorted by GPA: " + sortedByGpa);

        // 6. Peek: Print each student's name while counting them
        long studentCount = studentList.stream()
                .peek(student -> System.out.println("Student: " + student.getName()))
                .count();
        System.out.println("Total number of students: " + studentCount);

        // 7. Limit: Get first 3 students
        List<Student> firstThreeStudents = studentList.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First three students: " + firstThreeStudents);

        // 8. Skip: Skip the first 3 students
        List<Student> skippedStudents = studentList.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Students after skipping first 3: " + skippedStudents);

        // 9. Any Match: Check if any student has GPA above 3.9
        boolean anyHighGpa = studentList.stream()
                .anyMatch(student -> student.getGpa() > 3.9);
        System.out.println("Any student with GPA above 3.9: " + anyHighGpa);

        // 10. All Match: Check if all students are 18 or older
        boolean allAdult = studentList.stream()
                .allMatch(student -> student.getAge() >= 18);
        System.out.println("All students are 18 or older: " + allAdult);

        // 11. None Match: Check if no student has GPA below 2.0
        boolean noneLowGpa = studentList.stream()
                .noneMatch(student -> student.getGpa() < 2.0);
        System.out.println("No student with GPA below 2.0: " + noneLowGpa);

        // 12. Reduce: Find the student with the highest GPA
        Optional<Student> topStudent = studentList.stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
        topStudent.ifPresent(student -> System.out.println("Top student: " + student));

        // 13. Collect: Gather students with GPA below 3.0 into a list
        List<Student> lowGpaStudents = studentList.stream()
                .filter(student -> student.getGpa() < 3.0)
                .collect(Collectors.toList());
        System.out.println("Students with GPA below 3.0: " + lowGpaStudents);

        // 14. Count of students by major
        Map<Major, Long> majorCount = studentList.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));
        System.out.println("Count of students by major: " + majorCount);
    }

    public static void main(String[] args) {
        StudentExample example = new StudentExample();
        example.runExamples();
    }
}

